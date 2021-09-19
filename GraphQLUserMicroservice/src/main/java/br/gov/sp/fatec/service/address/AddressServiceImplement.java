package br.gov.sp.fatec.service.address;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;
import br.gov.sp.fatec.repository.AddressRepository;
import br.gov.sp.fatec.repository.UserRepository;

@Service
public class AddressServiceImplement implements AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Address> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Address createAddress(CreateAddressDto address) {
		Optional<User> user = userRepo.findById(address.getUserId());
		Address newAddress = new Address(address);
		
		if(!user.isPresent()) {
			throw new NotFoundException(String.format("Could not find User with id '%s'!", address.getUserId()));
		}
		
		User foundUser = user.get();
		foundUser.getAddresses().add(newAddress);
		userRepo.save(foundUser);
		
		newAddress.setUser(foundUser);
		
		return repository.save(newAddress);
	}
	
	@Override
	public Address getById(UUID id) {
		Optional<Address> address = repository.findById(id);
		
		if(!address.isPresent()) {
			throw new NotFoundException(String.format("Could not find Address with id '%s'!", id));
		}
		
		return address.get();
	}

	@Override
	public Address getByUserId(UUID userId) {
		Optional<Address> address = repository.findByUserId(userId);
		
		if(!address.isPresent()) {
			throw new NotFoundException(String.format("Could not find User with id '%s'!", userId));
		}
		
		return address.get();
	}

	@Override
	public Address updateAddress(UpdateAddressDto dto) {
		UUID id = dto.getAddressId();
		Optional<Address> optionalAddress = repository.findById(id);
		
		if(!optionalAddress.isPresent()) {
			throw new NotFoundException(String.format("Could not find Address with id '%s'!", id));
		}
		
		Address address = optionalAddress.get();
		return address;
	}

	@Override
	public String deleteAddress(UUID id) {
		Optional<Address> optionalAddress = repository.findById(id);
		
		if(!optionalAddress.isPresent()) {
			throw new NotFoundException(String.format("Address with id %s does not exists!", id));
		}
		
		Address address = optionalAddress.get();
		repository.delete(address);
		
		return String.format("Address with id '%s' deleted successfully!", address.getId());
	}
}
