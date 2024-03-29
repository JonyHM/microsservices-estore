package br.gov.sp.fatec.model.dto.customer;

import java.util.UUID;

import br.gov.sp.fatec.model.User;

public class UpdateKafkaCustomerDto {

	private UUID userId;
	private String name;
	private String email;
	private String cpf;
	
	public UpdateKafkaCustomerDto() {}

	public UpdateKafkaCustomerDto(
			UUID userId, 
			String name, 
			String email, 
			String cpf) {
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
	}

	public UpdateKafkaCustomerDto(User user) {
		this.userId = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "UpdateCustomerDto [userId=" + userId + 
				", name=" + name + 
				", email=" + email + 
				", cpf=" + cpf + "]";
	}
}
