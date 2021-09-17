package br.gov.sp.fatec.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.dto.CreateAddressDto;
import br.gov.sp.fatec.service.address.AddressService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class AddressMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private AddressService service;

	public Address createAddress(CreateAddressDto address) {
		return service.createAddress(address);
	}
}
