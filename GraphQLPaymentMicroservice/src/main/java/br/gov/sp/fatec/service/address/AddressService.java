package br.gov.sp.fatec.service.address;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;

public interface AddressService {

	public List<Address> getAll();
	public Address getById(UUID id);
	public List<Address> getByCustomerId(UUID customerId);
	public Address createAddress(CreateAddressDto dto);
	public Address updateAddress(UpdateAddressDto dto);
	public String deleteAddress(UUID id);
}
