package br.gov.sp.fatec.model.userMicroservice.user.dto;

import java.util.UUID;

public class UpdateUserDto extends CreateUserDto {

	private UUID userId;
	
	public UpdateUserDto() {}

	public UpdateUserDto(
			UUID userId,
			String name, 
			String email, 
			String cpf) {
		super(name, email, cpf);
		this.userId = userId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UpdateUserDto [userId=" + userId + "]";
	}
	
}
