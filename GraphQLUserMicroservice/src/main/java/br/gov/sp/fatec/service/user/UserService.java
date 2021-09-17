package br.gov.sp.fatec.service.user;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.CrateUserDto;

public interface UserService {

	public List<User> getAll();
	public User createUser(CrateUserDto user);
	public User getById(UUID id);
}
