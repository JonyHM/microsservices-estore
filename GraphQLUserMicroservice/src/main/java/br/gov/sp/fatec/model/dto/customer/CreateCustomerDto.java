package br.gov.sp.fatec.model.dto.customer;

import java.util.UUID;

import javax.validation.constraints.Pattern;

import br.gov.sp.fatec.model.User;

public class CreateCustomerDto {
	
	
	@Pattern(
		regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
		message = "formato de documento inválido"
	)
	private String cpf;
	private String name;
	private UUID userId;
	
	public CreateCustomerDto() {}
	
	public CreateCustomerDto(User user) {
		this.name = user.getName();
		this.userId = user.getId();
		this.cpf = user.getCpf();
	}

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
