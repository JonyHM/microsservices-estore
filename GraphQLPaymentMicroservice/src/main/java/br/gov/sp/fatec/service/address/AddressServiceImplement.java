package br.gov.sp.fatec.service.address;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.CreateAddressDto;
import br.gov.sp.fatec.repository.AddressRepository;
import br.gov.sp.fatec.repository.CustomerRepository;

@Service
public class AddressServiceImplement implements AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Address> getAll() {
		return repository.findAll();
	}

	@Override
	public Address createAddress(CreateAddressDto dto) throws NotFoundException {
		Optional<Customer> optionalCustomer = customerRepo.findById(dto.getCustomerId());
		Address address = new Address(dto);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			address.setCustomer(customer);
			Address newAddress = repository.save(address);
			
			Set<Address> addresses = customer.getAddresses();
			addresses.add(newAddress);
			customer.setAddresses(addresses);
			customerRepo.save(customer);
			return newAddress;
		}		
		throw new NotFoundException(String.format("Customer with id %s does not exist!", dto.getCustomerId()));
	}

	@Override
	public Address getById(UUID id) throws NotFoundException {
		Optional<Address> optionalAddress = repository.findById(id);
		
		if(optionalAddress.isPresent()) {
			return optionalAddress.get();
		}
		throw new NotFoundException(String.format("Could not find address with id %s!", id));
	}

	@Override
	public List<Address> getByCustomerId(UUID customerId) throws NotFoundException {
		Optional<List<Address>> optionalAddresses = repository.findByCustomerId(customerId);
		
		if(optionalAddresses.isPresent()) {
			return optionalAddresses.get();
		}
		throw new NotFoundException(String.format("Could not find address with id %s!", customerId));
	}

}
