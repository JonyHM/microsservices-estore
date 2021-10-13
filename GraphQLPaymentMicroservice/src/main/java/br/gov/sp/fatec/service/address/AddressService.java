package br.gov.sp.fatec.service.address;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.address.CreateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateKafkaAddressDto;

public interface AddressService {

	public List<Address> getAll();
	public Address getById(UUID id);
	public List<Address> getByCustomerId(UUID customerId);
	public Address createAddress(CreateAddressDto dto);
	public Address createkafkaAddress(CreateKafkaAddressDto dto);
	public Address updateAddress(UpdateAddressDto dto);
	public Address updateKafkaAddress(UpdateKafkaAddressDto dto);
	public String deleteAddress(UUID id);
	public String deleteByUserAddressId(UUID id);
}
