package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.service.price.PriceService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class PriceQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private PriceService service;
	
	public List<Price> getPrices() {
		return service.getAll();
	}
	
	public Price getPriceById(UUID id) {
		return service.getById(id);
	}
	
	public Price getPriceByOrderId(UUID orderId) {
		return service.getByOrderId(orderId);
	}
}
