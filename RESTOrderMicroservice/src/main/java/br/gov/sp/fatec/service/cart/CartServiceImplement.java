package br.gov.sp.fatec.service.cart;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.InvalidValueException;
import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.kafka.producer.OrderKafkaTopicProducer;
import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.OrderProduct;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.cart.AddProductDto;
import br.gov.sp.fatec.model.dto.cart.BaseCartDto;
import br.gov.sp.fatec.model.dto.cart.CreateCartDto;
import br.gov.sp.fatec.model.dto.cart.RemoveProductDto;
import br.gov.sp.fatec.model.dto.cart.UpdateCartDto;
import br.gov.sp.fatec.model.dto.order.KafkaOrderDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.enums.CartStatus;
import br.gov.sp.fatec.repository.CartRepository;
import br.gov.sp.fatec.repository.OrderProductRepository;
import br.gov.sp.fatec.repository.PriceRepository;

@Service
public class CartServiceImplement implements CartService {
	
	@Autowired
	private CartRepository repository;
	
	@Autowired
	private OrderProductRepository productRepository;
	
	@Autowired
	private PriceRepository priceRepository;
	
	@Autowired
	private OrderKafkaTopicProducer producer;

	@Override
	public Set<Cart> findCarts() {
		List<Cart> carts = repository.findAll(); 
		return new HashSet<Cart>(carts);
	}

	@Override
	public Set<Cart> findCartsForUserId(UUID userId) {
		Optional<Set<Cart>> carts = repository.findByUserId(userId);
		return carts.orElseThrow(
				() -> new NotFoundException(
						String.format("Could not find Carts for user with id '%s'", userId)
						)
				);
	}

	@Override
	public Cart findCart(UUID id) {
		Optional<Cart> cart = repository.findById(id);
		return cart.orElseThrow(
				() -> new NotFoundException(
						String.format("Could not find Cart with id '%s'", id)
						)
				);
	}

	@Override
	@Transactional
	public Cart createCart(CreateCartDto dto) {
		Map<CreateOrderProductDto, CreatePriceDto> pricesDtoMap = dto.getProducts()
				.stream()
				.collect(Collectors.toMap(p -> p, CreateOrderProductDto::getPrice));
		Set<OrderProduct> products = new HashSet<OrderProduct>();
		Price productsPrice = new Price("", new Double(0));
				
		pricesDtoMap.forEach((k, v) -> {
			Price price = new Price(v);
			price = priceRepository.save(price);
			
			UUID prodId = k.getProductId();
			Optional<OrderProduct> optionalProduct = productRepository.findById(prodId);
			OrderProduct product = optionalProduct.orElse(new OrderProduct(k));	
			
			productsPrice.setCurrency(price.getCurrency());
			productsPrice.addAmount(price.getAmount() * product.getQuantity());
			
			product.setPrice(price);
			product = productRepository.save(product);
			products.add(product);
			
			priceRepository.save(price);
		});
		
		Price price = new Price(dto.getTotalValue());
		price = priceRepository.save(price);
		
		if(!price.isEqualTo(productsPrice)) {
			throw new InvalidValueException(String.format("The sum of product values (%.2f) is different from the informed total value (%.2f)", 
					productsPrice.getAmount(), price.getAmount()));
		}

		Cart cart = new Cart(dto);
		cart.setTotalValue(price);
		cart.setProducts(products);
		cart = repository.save(cart);
		
		this.sendOrderStartedEvent(cart);
		
		return cart;
	}

	@Override
	@Transactional
	public Cart updateCart(UpdateCartDto dto) {
		UUID id = dto.getCartId();
		Optional<Cart> optionalCart = repository.findById(id);
		
		if(!optionalCart.isPresent()) {
			throw new NotFoundException(String.format("Could not find Cart with id '%s'", id));
		}
		
		Map<CreateOrderProductDto, CreatePriceDto> pricesDtoMap = dto.getProducts()
				.stream()
				.collect(Collectors.toMap(p -> p, CreateOrderProductDto::getPrice));
		Set<OrderProduct> products = new HashSet<OrderProduct>();
		Price productsPrice = new Price("", new Double(0));
				
		pricesDtoMap.forEach((k, v) -> {
			Price price = new Price(v);
			price = priceRepository.save(price);
			
			UUID prodId = k.getProductId();
			Optional<OrderProduct> optionalProduct = productRepository.findById(prodId);
			OrderProduct product = optionalProduct.orElse(new OrderProduct(k));	
			
			productsPrice.setCurrency(price.getCurrency());
			productsPrice.addAmount(price.getAmount() * product.getQuantity());
			
			product.setPrice(price);
			product = productRepository.save(product);
			products.add(product);
			priceRepository.save(price);
		});
		
		Cart cart = optionalCart.get();
		Price price = cart.getTotalValue();
		
		Double amount = price.getAmount() + productsPrice.getAmount();
		price.setAmount(amount);
		price = priceRepository.save(price);
		
		cart.setTotalValue(price);
		cart = cart.appendProducts(products);		
		
		return repository.save(cart);
	}

	@Override
	public String deleteCart(UUID id) {
		Optional<Cart> optionalCart = repository.findById(id);
		
		if(optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			repository.delete(cart);
			return String.format("Cart with id '%s' deleted successfully!", id);
		}
		
		throw new NotFoundException(String.format("Could not find Cart with id '%s'", id));
	}

	@Override
	@Transactional
	public Cart addProductToCart(AddProductDto dto) {
		UUID id = dto.getCartId();
		Optional<Cart> optionalCart = repository.findById(id);
		
		if(!optionalCart.isPresent()) {
			throw new NotFoundException(String.format("Could not find Cart with id '%s'", id));
		}
		
		Optional<OrderProduct> optionalProduct = productRepository.findByProductId(dto.getProduct().getProductId());
		OrderProduct product = new OrderProduct();
		Price productPrice = new Price(dto.getProduct().getPrice());
		
		if(optionalProduct.isPresent()) {
			product = optionalProduct.get();
			Long quantity = product.getQuantity();
			
			quantity = dto.getProduct().getQuantity() + quantity;
			product.setQuantity(quantity);
			
			Price oldPrice = product.getPrice();
			oldPrice.setAmount(productPrice.getAmount());
			productPrice = priceRepository.save(oldPrice);
		} else {
			product = new OrderProduct(dto.getProduct());
			productPrice = priceRepository.save(productPrice);
			product.setPrice(productPrice);
		}
		product = productRepository.save(product);
		
		Cart cart = optionalCart.get();
		Price price = cart.getTotalValue();
		
		Double amount = price.getAmount() + (product.getQuantity() * productPrice.getAmount());
		price.setAmount(amount);
		price = priceRepository.save(price);
		
		cart.setTotalValue(price);
		cart.appendProduct(product);
		return repository.save(cart);
	}

	@Override
	@Transactional
	public Cart removeOrderProductFromCart(RemoveProductDto dto) {
		UUID id = dto.getProductId();
		Optional<OrderProduct> optionalProduct = productRepository.findById(id);
		
		if(!optionalProduct.isPresent()) {
			throw new NotFoundException(String.format("Could not find order Product with id '%s'", id));
		}
		
		id = dto.getCartId();
		Optional<Cart> optionalCart = repository.findById(id);
		
		if(!optionalCart.isPresent()) {
			throw new NotFoundException(String.format("Could not find Cart with id '%s'", id));
		}
		
		OrderProduct product = optionalProduct.get();
		Cart cart = optionalCart.get();
		Price price = cart.getTotalValue();
		
		Double amount = price.getAmount() - (product.getQuantity() * product.getPrice().getAmount());
		price.setAmount(amount);
		price = priceRepository.save(price);
		
		cart.setTotalValue(price);
		cart.removeProduct(product);
		productRepository.delete(product);
		
		return repository.save(cart);
	}
	
	@Override
	public void updatePaidCart(KafkaOrderDto dto) {
		UUID id = dto.getCartId();
		Optional<Cart> optionalCart = repository.findById(id);
		
		if(optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			cart.setStatus(CartStatus.PAID);
			cart = repository.save(cart);
			this.sendCartPaidEvent(cart);
			return;
		}
		
		throw new NotFoundException(String.format("Could not find Cart with id '%s'", id));		
	}

	@Override
	public void updateCanceledCart(KafkaOrderDto dto) {
		UUID id = dto.getCartId();
		Optional<Cart> optionalCart = repository.findById(id);
		
		if(optionalCart.isPresent()) {
			Cart cart = optionalCart.get();
			cart.setStatus(CartStatus.CANCELED);
			cart = repository.save(cart);
			this.sendCartCanceledEvent(cart);
			return;
		}
		
		throw new NotFoundException(String.format("Could not find Cart with id '%s'", id));
	}
	
	private void sendOrderStartedEvent(Cart cart) {
		StartOrderDto dto = new StartOrderDto(cart);
		producer.sendOrderStarted(dto);
	}
	
	private void sendCartPaidEvent(Cart cart) {
		BaseCartDto dto = new BaseCartDto(cart);
		producer.sendCartPaid(dto);
	}
	
	private void sendCartCanceledEvent(Cart cart) {
		BaseCartDto dto = new BaseCartDto(cart);
		producer.sendCartCanceled(dto);
	}
}
