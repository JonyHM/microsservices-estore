package br.gov.sp.fatec.service.address;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.dto.CreateAddressDto;
import javassist.NotFoundException;

public interface AddressService {

	public List<Address> getAll();
	public Address createAddress(CreateAddressDto dto) throws NotFoundException;
	public Address getById(UUID id) throws NotFoundException;
	public List<Address> getByCustomerId(UUID customerId) throws NotFoundException;
}
