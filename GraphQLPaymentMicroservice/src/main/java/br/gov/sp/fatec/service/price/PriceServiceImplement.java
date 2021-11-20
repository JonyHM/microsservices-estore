package br.gov.sp.fatec.service.price;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;
import br.gov.sp.fatec.repository.OrderRepository;
import br.gov.sp.fatec.repository.PriceRepository;

@Service
public class PriceServiceImplement implements PriceService {
	
	@Autowired
	private PriceRepository repository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Price> getAll() {
		return repository.findAll();
	}

	@Override
	public Price getById(UUID id) {
		Optional<Price> optionalPrice = repository.findById(id);
		
		if(!optionalPrice.isPresent()) {
			throw new NotFoundException(String.format("Could not find Price with id '%s'", id));
		}
		
		Price price = optionalPrice.get();
		
		return price;
	}

	@Override
	public Price getByOrderId(UUID orderId) {
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		if(!optionalOrder.isPresent()) {
			throw new NotFoundException(String.format("Could not find Order with id '%s'", orderId));
		}
		
		Order order = optionalOrder.get();
		Price price = order.getPrice();
		
		return price;
	}

	@Override
	@Transactional
	public Price createPrice(CreatePriceDto dto) {
		Optional<Order> optionalOrder = orderRepository.findById(dto.getOrderId());
		
		if(!optionalOrder.isPresent()) {
			throw new NotFoundException(String.format("Could not find Order with id '%s'", dto.getOrderId()));
		}
		
		Price price = new Price(dto);
		price = repository.save(price);
		
		Order order = optionalOrder.get();
		order.setPrice(price);
		orderRepository.save(order);
		
		return price;
	}

	@Override
	public Price updatePrice(UpdatePriceDto dto) {
		Price price = getById(dto.getPriceId());
		price = price.updateEntity(dto);
		
		return repository.save(price);
	}

	@Override
	public String deletePrice(UUID id) {
		Price price = getById(id);
		repository.delete(price);
		return String.format("Price with id '%s' deleted successfully!", id);
	}

}
