package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.service.address.AddressService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javassist.NotFoundException;

@Component
public class AddressQueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	private AddressService service;
	
	public List<Address> getAddresses() {
		return service.getAll();
	}
	
	public Address getAddressById(UUID id) throws NotFoundException {
		return service.getById(id);
	}

	public List<Address> getAddressesByCustomerId(UUID customerId) throws NotFoundException {
		return service.getByCustomerId(customerId);
	}

}
