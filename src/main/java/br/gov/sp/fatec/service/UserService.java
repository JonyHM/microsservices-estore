package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.User;

public interface UserService {

	public List<User> getAll();
	public User createUser(User user);
	public User getById(Long id);
}
