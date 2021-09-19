package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.dto.order.CreateOrderDto;
import br.gov.sp.fatec.model.dto.order.UpdateOrderDto;
import br.gov.sp.fatec.service.order.OrderService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private OrderService service;

	public Order createOrder(CreateOrderDto order) {
		return service.createOrder(order);
	}
	
	public Order updateOrder(UpdateOrderDto order) {
		return service.updateOrder(order);
	}
	
	public String deleteOrder(UUID orderId) {
		return service.deleteOrder(orderId);
	}
}
