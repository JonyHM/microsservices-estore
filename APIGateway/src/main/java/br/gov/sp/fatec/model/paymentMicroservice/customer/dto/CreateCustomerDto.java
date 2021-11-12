package br.gov.sp.fatec.model.paymentMicroservice.customer.dto;

import java.util.UUID;

public class CreateCustomerDto {

	private UUID userId;
	private String name;
	private String cpf;
	
	public CreateCustomerDto() {}

	public CreateCustomerDto(
			UUID userId, 
			String name, 
			String cpf) {
		this.userId = userId;
		this.name = name;
		this.cpf = cpf;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "CreateCustomerDto [userId=" + userId + 
				", name=" + name + 
				", cpf=" + cpf + "]";
	}
	
}
