package br.gov.sp.fatec.model.userMicroservice.user.data;

import br.gov.sp.fatec.model.userMicroservice.user.dto.UserDto;

public class UpdateUserData {

	private UserDto updateUser;
	
	public UpdateUserData() {}

	public UpdateUserData(UserDto updateUser) {
		this.updateUser = updateUser;
	}

	public UserDto getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(UserDto updateUser) {
		this.updateUser = updateUser;
	}

	@Override
	public String toString() {
		return "UpdateUserData [updateUser=" + updateUser + "]";
	}
	
}
