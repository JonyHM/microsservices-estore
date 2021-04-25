package br.gov.sp.fatec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
