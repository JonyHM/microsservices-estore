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

import br.gov.sp.fatec.exception.InvalidValueException;
import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Cart;
import br.gov.sp.fatec.model.OrderProduct;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.CreatePriceDto;
import br.gov.sp.fatec.model.dto.cart.CreateCartDto;
import br.gov.sp.fatec.model.dto.cart.UpdateCartDto;
import br.gov.sp.fatec.repository.CartRepository;
import br.gov.sp.fatec.repository.PriceRepository;
import br.gov.sp.fatec.repository.ProductRepository;

public class CartServiceImplement implements CartService {
	
	@Autowired
	private CartRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PriceRepository priceRepository;

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
		Price productsPrice = new Price();
				
		pricesDtoMap.forEach((k, v) -> {
			Price price = new Price(v);
			productsPrice.setCurrency(price.getCurrency());
			productsPrice.addAmount(price.getAmount());
			price = priceRepository.save(price);
			OrderProduct product = new OrderProduct(k);
			product.setPrice(price);
			product = productRepository.save(product);
			products.add(product);
		});
		
		Price price = new Price(dto.getTotalValue());
		price = priceRepository.save(price);
		
		if(!price.isEqualTo(productsPrice)) {
			throw new InvalidValueException(String.format("The sum of product values (%.2f) is different from the informed total value (%.2f)", 
					productsPrice.getAmount(), price.getAmount()));
		}
		// Create new cart and set price and products to it
		
		return null;
	}

	@Override
	public Cart updateCart(UpdateCartDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCart(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
