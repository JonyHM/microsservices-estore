package br.gov.sp.fatec.model.paymentMicroservice.customer.dto;

import java.util.UUID;

public class UpdateCustomerDto {

	private UUID customerId;
	private String name;
	private String cpf;
	
	public UpdateCustomerDto() {}

	public UpdateCustomerDto(
			UUID customerId, 
			String name, 
			String cpf) {
		this.customerId = customerId;
		this.name = name;
		this.cpf = cpf;
	}

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
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
		return "UpdateCustomerDto [customerId=" + customerId + 
				", name=" + name + 
				", cpf=" + cpf + "]";
	}
	
}
