package br.gov.sp.fatec.service.order;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.order.CreateOrderDto;
import br.gov.sp.fatec.model.dto.order.UpdateOrderDto;
import br.gov.sp.fatec.repository.CustomerRepository;
import br.gov.sp.fatec.repository.OrderRepository;
import br.gov.sp.fatec.repository.PriceRepository;

@Service
public class OrderServiceImplement implements OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private PriceRepository priceRepo;

	@Override
	public List<Order> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Order createOrder(CreateOrderDto dto) {
		Optional<Customer> optionalCustomer = customerRepo.findByUserId(dto.getUserId());
		Order order = new Order(dto);
		Price price = new Price(dto.getPrice());
		price = priceRepo.save(price);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			order.setCustomer(customer);
			order.setPrice(price);
			Order newOrder = repository.save(order);
			
			Set<Order> orders = customer.getOrders();
			orders.add(newOrder);
			customer.setOrders(orders);
			customerRepo.save(customer);
			return newOrder;
		}
		throw new NotFoundException(String.format("Could not find Customer with userId '%s'!", dto.getUserId()));
	}

	@Override
	public Order getById(UUID id) {
		Optional<Order> optionalOrder = repository.findById(id);
		
		if(optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		throw new NotFoundException(String.format("Could not find Order with id '%s'!", id));
	}

	@Override
	public List<Order> getByCustomerId(UUID customerId) {
		Optional<List<Order>> optionalOrders = repository.findByCustomerId(customerId);
		
		if(optionalOrders.isPresent()) {
			return optionalOrders.get();
		}
		throw new NotFoundException(String.format("Could not find Customer Order with id '%s'!", customerId));
	}

	@Override
	public Order updateOrder(UpdateOrderDto dto) {
		UUID id = dto.getOrderId();
		Optional<Order> optionalOrder = repository.findById(id);
		
		if(optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			return repository.save(order.updateEntity(dto));
		}
		throw new NotFoundException(String.format("Could not find Order with id '%s'!", id));
	}

	@Override
	public String deleteOrder(UUID id) {
		Optional<Order> optionalOrder = repository.findById(id);
		
		if(optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			repository.delete(order);
			return String.format("Order with id '%s' deleted successfully!", id);
		}
		throw new NotFoundException(String.format("Could not find Order with id '%s'!", id));
	}

}
