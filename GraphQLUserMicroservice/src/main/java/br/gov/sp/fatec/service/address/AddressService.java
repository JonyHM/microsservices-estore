package br.gov.sp.fatec.service.address;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.dto.CreateAddressDto;

public interface AddressService {

	public List<Address> getAll();
	public Address createAddress(CreateAddressDto address);
	public Address getById(UUID id);
	public Address getByUserId(UUID userId);
}
