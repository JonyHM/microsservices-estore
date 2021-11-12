package br.gov.sp.fatec.model.userMicroservice.user.data;

import java.util.Set;

import br.gov.sp.fatec.model.userMicroservice.user.dto.UserDto;

public class GetUsersData {

	private Set<UserDto> getUsers;
	
	public GetUsersData() {}

	public GetUsersData(Set<UserDto> getUsers) {
		this.getUsers = getUsers;
	}

	public Set<UserDto> getGetUsers() {
		return getUsers;
	}

	public void setGetUsers(Set<UserDto> getUsers) {
		this.getUsers = getUsers;
	}

	@Override
	public String toString() {
		return "GetUsersData [getUsers=" + getUsers + "]";
	}
	
}
