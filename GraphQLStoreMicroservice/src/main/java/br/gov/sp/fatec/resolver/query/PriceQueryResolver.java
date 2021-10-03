package br.gov.sp.fatec.resolver.query;

import java.util.Set;
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
	
	public Set<Price> getPrices() {
		return service.getPrices();
	}
	
	public Price getPriceById(UUID id) {
		return service.getPriceById(id);
	}
	
	public Price getPriceByProductId(UUID productId) {
		return service.getPriceByProductId(productId);
	}
}
