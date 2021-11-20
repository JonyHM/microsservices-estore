package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.service.order.OrderService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javassist.NotFoundException;

@Component
public class OrderQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	private OrderService service;
	
	public List<Order> getOrders() {
		return service.getAll();
	}
	
	public Order getOrderById(UUID id) throws NotFoundException {
		return service.getById(id);
	}

	public List<Order> getOrdersByCustomerId(UUID customerId) throws NotFoundException {
		return service.getByCustomerId(customerId);
	}

}
