package br.gov.sp.fatec.model.userMicroservice.user.dto;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.userMicroservice.address.dto.AddressDto;
import br.gov.sp.fatec.model.userMicroservice.contact.dto.ContactDto;

public class UserDto {

	private UUID id;
	private String name;
	private String email;
	private String cpf;
	private Set<ContactDto> contacts;
	private Set<AddressDto> addresses;

	public UserDto() {}

	public UserDto(
			UUID id, 
			String name, 
			String email, 
			String cpf, 
			Set<ContactDto> contacts,
			Set<AddressDto> addresses) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.contacts = contacts;
		this.addresses = addresses;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Set<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public Set<AddressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressDto> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", cpf=" + cpf + ", contacts=" + contacts
				+ ", addresses=" + addresses + "]";
	}

}
