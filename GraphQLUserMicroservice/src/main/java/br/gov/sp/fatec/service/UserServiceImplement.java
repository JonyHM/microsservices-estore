package br.gov.sp.fatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.User;
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
	public User createUser(User user) {
		return repository.save(user);
	}
	
	@Override
	@Transactional
	public User getById(Long id) {
		Optional<User> user = repository.findById(id);
		
		if(!user.isPresent()) {
			throw new RuntimeException("Usuário não encontrado!");
		}
		
		return user.get();
	}
}
