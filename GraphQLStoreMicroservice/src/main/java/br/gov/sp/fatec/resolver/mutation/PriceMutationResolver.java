package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.model.Price;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;
import br.gov.sp.fatec.service.price.PriceService;
import graphql.kickstart.tools.GraphQLMutationResolver;

public class PriceMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private PriceService service;
	
	public Price createPrice(CreatePriceDto price) {
		return service.createPrice(price);
	}
	
	public Price updatePrice(UpdatePriceDto price) {
		return service.updatePrice(price);
	}
	
	public String deletePrice(UUID priceId) {
		return service.deletePrice(priceId);
	}
}
