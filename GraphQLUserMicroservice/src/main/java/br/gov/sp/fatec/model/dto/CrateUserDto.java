package br.gov.sp.fatec.model.dto;

import javax.validation.constraints.Pattern;

public class CrateUserDto {

	private String name;
	private String email;
	
	@Pattern(
		regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
		message = "formato de documento inválido"
	)
	private String cpf;
	
	public CrateUserDto() {}

	public CrateUserDto(
			String name, 
			String email,
			@Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
			message = "formato de documento inválido") String cpf) {
		this.name = name;
		this.email = email;
		this.cpf = cpf;
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
		return "CrateUserDto [name=" + name + ", email=" + email + ", cpf=" + cpf + "]";
	}
	
}
