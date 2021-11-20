package br.gov.sp.fatec.service.address;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.kafka.producer.UserKafkaTopicProducer;
import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.address.CreateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateKafkaAddressDto;
import br.gov.sp.fatec.repository.AddressRepository;
import br.gov.sp.fatec.repository.UserRepository;

@Service
public class AddressServiceImplement implements AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserKafkaTopicProducer producer;

	@Override
	public Set<Address> getAll() {
		List<Address> addresses = repository.findAll(); 
		return new HashSet<Address>(addresses);
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
		newAddress = repository.save(newAddress);
		this.sendAddressCreatedEvent(newAddress);
		
		return newAddress;
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
	public Set<Address> getByUserId(UUID userId) {
		Optional<Set<Address>> addresses = repository.findByUserId(userId);
		
		if(!addresses.isPresent()) {
			throw new NotFoundException(String.format("Could not find User with id '%s'!", userId));
		}
		
		return addresses.get();
	}

	@Override
	public Address updateAddress(UpdateAddressDto dto) {
		UUID id = dto.getAddressId();
		Optional<Address> optionalAddress = repository.findById(id);
		
		if(!optionalAddress.isPresent()) {
			throw new NotFoundException(String.format("Could not find Address with id '%s'!", id));
		}
		
		Address address = optionalAddress.get();
		address = address.updateEntity(dto);
		address = repository.save(address);
		
		this.sendAddressUpdatedEvent(address);
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
		this.sendAddressDeletedEvent(address);
		
		return String.format("Address with id '%s' deleted successfully!", address.getId());
	}
	
	private void sendAddressCreatedEvent(Address address) {
		CreateKafkaAddressDto dto = new CreateKafkaAddressDto(address);
		producer.sendAddressCreated(dto);
	}
	
	private void sendAddressUpdatedEvent(Address address) {
		UpdateKafkaAddressDto dto = new UpdateKafkaAddressDto(address);
		producer.sendAddressUpdated(dto);
	}
	
	private void sendAddressDeletedEvent(Address address) {
		producer.sendAddressDeleted(address.getId());
	}
}
