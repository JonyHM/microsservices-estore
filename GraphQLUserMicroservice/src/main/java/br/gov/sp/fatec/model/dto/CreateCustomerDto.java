package br.gov.sp.fatec.model.dto;

import java.util.UUID;

import javax.validation.constraints.Pattern;

public class CreateCustomerDto {
	
	private String name;
	private UUID userId;
	
	@Pattern(
		regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
		message = "formato de documento inválido"
	)
	private String cpf;
	
	public CreateCustomerDto() {}

	public CreateCustomerDto(String name, UUID userId, String cpf) {
		this.name = name;
		this.userId = userId;
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "CreateCustomerDto [name=" + name + ", user id=" + userId + ", cpf=" + cpf + "]";
	}
}
