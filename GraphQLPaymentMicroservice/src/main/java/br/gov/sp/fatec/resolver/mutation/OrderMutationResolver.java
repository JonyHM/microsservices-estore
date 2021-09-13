package br.gov.sp.fatec.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.dto.CreateOrderDto;
import br.gov.sp.fatec.service.order.OrderService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class OrderMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private OrderService service;

	public Order createOrder(CreateOrderDto dto) throws NotFoundException {
		return service.createOrder(dto);
	}
}
