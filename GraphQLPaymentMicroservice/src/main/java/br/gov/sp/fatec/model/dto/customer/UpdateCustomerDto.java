package br.gov.sp.fatec.model.dto.customer;

import java.util.UUID;

import javax.validation.constraints.Pattern;

public class UpdateCustomerDto {

	private UUID customerId;
	private String name;
	
	@Pattern(
		regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
		message = "formato de documento inválido"
	)
	private String cpf;
	
	public UpdateCustomerDto() {}

	public UpdateCustomerDto(
			UUID customerId, 
			String name, 
			@Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
			message = "formato de documento inválido") String cpf) {
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
