package br.gov.sp.fatec.resolver.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.service.AddressService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class AddressQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private AddressService service;
	
	public List<Address> getAddresses() {
		return service.getAll();
	}
	
	public Address getAddressById(Long id) {
		return service.getById(id);
	}
	
	public Address getAddressByUserId(Long userId) {
		return service.getByUserId(userId);
	}
}
