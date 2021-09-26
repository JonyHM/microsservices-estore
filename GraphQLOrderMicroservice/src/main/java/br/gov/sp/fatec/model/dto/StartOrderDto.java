package br.gov.sp.fatec.model.dto;

import java.util.UUID;

public class StartOrderDto {

	private UUID userId;
	private String description;
	
	public StartOrderDto() {}

	public StartOrderDto(UUID userId, String description) {
		this.userId = userId;
		this.description = description;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CreateCustomerDto [userId=" + userId + ", description=" + description + "]";
	}
	
}
