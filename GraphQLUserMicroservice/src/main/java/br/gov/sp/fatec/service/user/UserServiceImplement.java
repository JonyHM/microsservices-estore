package br.gov.sp.fatec.service.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.CrateUserDto;
import br.gov.sp.fatec.repository.UserRepository;

@Service
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}
	
	@Override
	public User createUser(CrateUserDto user) {
		return repository.save(new User(user));
	}
	
	@Override
	@Transactional
	public User getById(UUID id) {
		Optional<User> user = repository.findById(id);
		
		if(!user.isPresent()) {
			throw new NotFoundException(String.format("User with id %s does not exists!", id));
		}
		
		return user.get();
	}
}