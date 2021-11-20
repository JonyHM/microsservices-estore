package br.gov.sp.fatec.service.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.kafka.producer.UserKafkaTopicProducer;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateKafkaCustomerDto;
import br.gov.sp.fatec.model.dto.user.CrateUserDto;
import br.gov.sp.fatec.model.dto.user.UpdateUserDto;
import br.gov.sp.fatec.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserKafkaTopicProducer producer;

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	
	@Override
	public User createUser(CrateUserDto user) {
		User newUser = repository.save(new User(user)); 
		this.sendUserCreatedEvent(newUser);
		return newUser;
	}
	
	@Override
	@Transactional
	public User getById(UUID id) {
		Optional<User> optionalUser = repository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new NotFoundException(String.format("Could not find User with id '%s'!", id));
		}
		
		return optionalUser.get();
	}

	@Override
	public User updateUser(UpdateUserDto dto) {
		UUID id = dto.getUserId();
		Optional<User> optionalUser = repository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new NotFoundException(String.format("Could not find User with id '%s'!", id));
		}
		
		User user = optionalUser.get();
		user = user.updateEntity(dto);
		user = repository.save(user);
		this.sendUserUpdatedEvent(user);
		return user;
	}

	@Override
	public String deleteUser(UUID id) {
		Optional<User> optionalUser = repository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new NotFoundException(String.format("Could not find User with id '%s'!", id));
		}
		
		User user = optionalUser.get();
		repository.delete(user);
		this.sendUserDeletedEvent(user);
		
		return String.format("User '%s' deleted successfully!", user.getName());
	}
	
	
	private void sendUserCreatedEvent(User user) {
		CreateCustomerDto dto = new CreateCustomerDto(user);
		producer.sendUserCreated(dto);
	}
	
	private void sendUserUpdatedEvent(User user) {
		UpdateKafkaCustomerDto dto = new UpdateKafkaCustomerDto(user);
		producer.sendUserUpdated(dto);
	}
	
	private void sendUserDeletedEvent(User user) {
		producer.sendUserDeleted(user.getId());
	}
}
