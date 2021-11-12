package br.gov.sp.fatec.model.userMicroservice.user.data;

import br.gov.sp.fatec.model.userMicroservice.user.dto.UserDto;

public class CreateUserData {

	private UserDto createUser;
	
	public CreateUserData() {}

	public CreateUserData(UserDto createUser) {
		this.createUser = createUser;
	}

	public UserDto getCreateUser() {
		return createUser;
	}

	public void setCreateUser(UserDto createUser) {
		this.createUser = createUser;
	}

	@Override
	public String toString() {
		return "CreateUserData [createUser=" + createUser + "]";
	}

}
