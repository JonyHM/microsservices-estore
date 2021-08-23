package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Address;

public interface AddressService {

	public List<Address> getAll();
	public Address createAddress(Address address, Long userId);
	public Address getById(Long id);
	public Address getByUserId(Long userId);
}
