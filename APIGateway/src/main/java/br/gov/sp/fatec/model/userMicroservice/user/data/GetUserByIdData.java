package br.gov.sp.fatec.model.userMicroservice.user.data;

import java.util.Set;

import br.gov.sp.fatec.model.userMicroservice.user.dto.UserDto;

public class GetUserByIdData {

	private Set<UserDto> getUserById;
	
	public GetUserByIdData() {}

	public GetUserByIdData(Set<UserDto> getUserById) {
		this.getUserById = getUserById;
	}

	public Set<UserDto> getGetUserById() {
		return getUserById;
	}

	public void setGetUserById(Set<UserDto> getUserById) {
		this.getUserById = getUserById;
	}

	@Override
	public String toString() {
		return "GetUserByIdData [getUserById=" + getUserById + "]";
	}

}
