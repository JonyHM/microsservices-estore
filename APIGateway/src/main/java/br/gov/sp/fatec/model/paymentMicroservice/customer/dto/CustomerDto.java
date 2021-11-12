package br.gov.sp.fatec.model.paymentMicroservice.customer.dto;

import java.util.UUID;

public class CustomerDto {

	private UUID id;
	private String userId;
	private String name;
	private String cpf;
	
	public CustomerDto() {}

	public CustomerDto(
			UUID id, 
			String userId, 
			String name, 
			String cpf) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.cpf = cpf;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
		return "CustomerDto [id=" + id + 
				", userId=" + userId + 
				", name=" + name + 
				", cpf=" + cpf + "]";
	}
	
}
