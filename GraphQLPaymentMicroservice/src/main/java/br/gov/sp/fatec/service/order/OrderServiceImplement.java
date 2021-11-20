package br.gov.sp.fatec.service.order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.kafka.producer.PaymentKafkaTopicProducer;
import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.order.CreateOrderDto;
import br.gov.sp.fatec.model.dto.order.KafkaOrderDto;
import br.gov.sp.fatec.model.dto.order.OrderManagementDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.model.dto.order.UpdateOrderDto;
import br.gov.sp.fatec.model.enums.OrderStatus;
import br.gov.sp.fatec.repository.CardRepository;
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
	private CardRepository cardRepo;
	
	@Autowired
	private PriceRepository priceRepo;
	
	@Autowired
	private PaymentKafkaTopicProducer producer;

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

	@Override
	public void startOrder(StartOrderDto dto) {
		Optional<Customer> optionalCustomer = customerRepo.findByUserId(dto.getUserId());
		Price price = new Price(dto.getPrice());
		price = priceRepo.save(price);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			System.out.println(dto);
			Order order = new Order(dto);
			System.out.println(order);
			order.setCustomer(customer);
			order.setPrice(price);
			repository.save(order);
			return;
		}
		throw new NotFoundException(String.format("Could not find Customer with userId '%s'!", dto.getUserId()));
	}
	
	@Override
	public String payOrder(OrderManagementDto dto) {
		Optional<Order> optionalOrder = repository.findById(dto.getOrderId());
		Optional<Card> optionalCard = cardRepo.findById(dto.getCardId());
		
		Order order = optionalOrder.orElseThrow(
			() -> new NotFoundException(String.format("Could not find order with id '%s'!", dto.getOrderId()))
		);
		
		if(!order.getStatus().toString().equalsIgnoreCase("OPENED")) {
			throw new NotFoundException("You cannot pay a cart that has already been finished!");
		}
		
		if(!optionalCard.isPresent()) {			
			throw new NotFoundException(String.format("Could not find card with id '%s'!", dto.getCardId()));
		}
        
		System.out.println(order);
		order.setStatus(OrderStatus.PAID);
		repository.save(order);
		this.sendOrderPaidEvent(dto.getCartId(), dto.getOrderId());
		
		return String.format("Order '%s' paid successfully!", dto.getOrderId());
	}
	
	@Override
	public String cancelOrder(OrderManagementDto dto) {
		Optional<Order> optionalOrder = repository.findById(dto.getOrderId());
		Optional<Card> optionalCard = cardRepo.findById(dto.getCardId());
		
		Order order = optionalOrder.orElseThrow(
			() -> new NotFoundException(String.format("Could not find order with id '%s'!", dto.getOrderId()))
		);
		
		if(!order.getStatus().toString().equalsIgnoreCase("OPENED")) {
			throw new NotFoundException("You cannot cancel a cart that has already been finished!");
		}
		
		if(!optionalCard.isPresent()) {			
			throw new NotFoundException(String.format("Could not find card with id '%s'!", dto.getCardId()));
		}
		
		order.setStatus(OrderStatus.CANCELED);
		repository.save(order);
		this.sendOrderCanceledEvent(dto.getCartId(), dto.getOrderId());
		
		return String.format("Order '%s' canceled successfully!", dto.getOrderId());
	}
	
	private void sendOrderPaidEvent(String cartId, UUID orderId) {
		KafkaOrderDto dto = new KafkaOrderDto(cartId, orderId);
		System.out.println("DTO -> " + dto);
		producer.sendOrderPaid(dto);
	}
	
	private void sendOrderCanceledEvent(String cartId, UUID orderId) {
		KafkaOrderDto dto = new KafkaOrderDto(cartId, orderId);
		System.out.println("DTO -> " + dto);
		producer.sendOrderCanceled(dto);
	}
}
