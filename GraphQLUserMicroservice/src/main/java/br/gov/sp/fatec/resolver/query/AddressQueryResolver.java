package br.gov.sp.fatec.resolver.query;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.service.address.AddressService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class AddressQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private AddressService service;
	
	public Set<Address> getAddresses() {
		return service.getAll();
	}
	
	public Address getAddressById(UUID id) {
		return service.getById(id);
	}
	
	public Set<Address> getAddressesByUserId(UUID userId) {
		return service.getByUserId(userId);
	}
}
