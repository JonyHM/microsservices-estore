package br.gov.sp.fatec.service.user;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.user.CrateUserDto;
import br.gov.sp.fatec.model.dto.user.UpdateUserDto;

public interface UserService {

	public List<User> getAll();
	public User getById(UUID id);
	public User createUser(CrateUserDto dto);
	public User updateUser(UpdateUserDto dto);
	public String deleteUser(UUID id);
}
