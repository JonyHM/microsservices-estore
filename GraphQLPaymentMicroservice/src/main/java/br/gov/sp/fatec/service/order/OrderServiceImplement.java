package br.gov.sp.fatec.service.order;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.dto.CreateOrderDto;
import br.gov.sp.fatec.repository.CustomerRepository;
import br.gov.sp.fatec.repository.OrderRepository;
import javassist.NotFoundException;

@Service
public class OrderServiceImplement implements OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Order> getAll() {
		return repository.findAll();
	}

	@Override
	public Order createOrder(CreateOrderDto dto) throws NotFoundException {
		Optional<Customer> optionalCustomer = customerRepo.findByUserId(dto.getUserId());
		Order order = new Order(dto);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			order.setCustomer(customer);
			Order newOrder = repository.save(order);
			
			Set<Order> orders = customer.getOrders();
			orders.add(newOrder);
			customer.setOrders(orders);
			customerRepo.save(customer);
			return newOrder;
		}
		throw new NotFoundException(String.format("Customer with user id %s does not exists!", dto.getUserId()));
	}

	@Override
	public Order getById(UUID id) throws NotFoundException {
		Optional<Order> optionalOrder = repository.findById(id);
		
		if(optionalOrder.isPresent()) {
			return optionalOrder.get();
		}
		throw new NotFoundException(String.format("Order with id %s does not exists!", id));
	}

	@Override
	public List<Order> getByCustomerId(UUID customerId) throws NotFoundException {
		Optional<List<Order>> optionalOrders = repository.findByCustomerId(customerId);
		
		if(optionalOrders.isPresent()) {
			return optionalOrders.get();
		}
		throw new NotFoundException(String.format("Customer Order with id %s does not exists!", customerId));
	}

}
