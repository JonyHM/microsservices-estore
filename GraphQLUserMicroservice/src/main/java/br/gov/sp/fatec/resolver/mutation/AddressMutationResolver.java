package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;
import br.gov.sp.fatec.service.address.AddressService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class AddressMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private AddressService service;
	
	public Address createAddress(CreateAddressDto address) {
		Address addressModel = service.createAddress(address);
		return addressModel;
	}
	
	public Address updateAddress(UpdateAddressDto address) {
		return service.updateAddress(address);
	}
	
	public String deleteAddress(UUID addressId) {
		return service.deleteAddress(addressId);
	}
	
}
