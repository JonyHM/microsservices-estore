package br.gov.sp.fatec.service.order;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.OrderProduct;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.orderProduct.UpdateOrderProductDto;
import br.gov.sp.fatec.repository.OrderProductRepository;
import br.gov.sp.fatec.repository.PriceRepository;

@Service
public class OrderProductServiceImplement implements OrderProductService {
	
	@Autowired
	private OrderProductRepository repository;
	
	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Set<OrderProduct> findOrderProducts() {
		List<OrderProduct> products = repository.findAll(); 
		return new HashSet<OrderProduct>(products);
	}

	@Override
	public OrderProduct findOrderProductForProductId(UUID productId) {
		Optional<OrderProduct> optionalProduct = repository.findByProductId(productId);
		return optionalProduct.orElseThrow(
			() -> new NotFoundException(
				String.format("Could not find OrderProduct with productid '%s'", productId)
			)
		);
	}

	@Override
	public OrderProduct findOrderProduct(UUID id) {
		Optional<OrderProduct> optionalProduct = repository.findById(id);
		return optionalProduct.orElseThrow(
			() -> new NotFoundException(
				String.format("Could not find OrderProduct with id '%s'", id)
			)
		);
	}

	@Override
	public OrderProduct createOrderProduct(CreateOrderProductDto dto) {
		Price price = new Price(dto.getPrice());
		price = priceRepository.save(price);
		OrderProduct product = new OrderProduct(dto);
		product.setPrice(price);
		return repository.save(product);
	}

	@Override
	public OrderProduct updateOrderProduct(UpdateOrderProductDto dto) {
		UUID id = dto.getProductId();
		Optional<OrderProduct> optionalProduct = repository.findById(id);
		
		if(!optionalProduct.isPresent()) {
			throw new NotFoundException(String.format("Could not find OrderProduct with id '%s'", id));
		}
		
		OrderProduct product = optionalProduct.get();
		Price price = product.getPrice();
		price = price.updateEntity(dto.getPrice());
		
		product = product.updateEntity(dto);
		
		return repository.save(product);
	}

	@Override
	public String deleteOrderProduct(UUID id) {
		Optional<OrderProduct> optionalProduct = repository.findById(id);
		
		if(!optionalProduct.isPresent()) {
			throw new NotFoundException(String.format("Could not find OrderProduct with id '%s'", id));
		}
		
		OrderProduct product = optionalProduct.get();
		repository.delete(product);
		
		return String.format("OrderProduct '%s' deleted successfully!", product.getName());
	}

}
