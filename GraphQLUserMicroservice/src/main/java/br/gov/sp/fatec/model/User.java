package br.gov.sp.fatec.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.CrateUserDto;

@Entity
public class User {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_user", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(length = 40)
	private String name;
	
	@OneToMany(
    	mappedBy = "user",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Address> addresses = new HashSet<Address>();
	
	@Column(length = 50)
	private String email;
	
	@Column(unique = true, length = 14)
	private String cpf;
	
	@OneToMany(
    	mappedBy = "user",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Contact> contacts = new HashSet<Contact>();
	
	public User() {}
	
	public User(CrateUserDto dto) {
		this.name = dto.getName();
		this.email = dto.getEmail();
		this.cpf = dto.getCpf();
	}

	public User(
			String name, 
			Set<Address> addresses, 
			String email, 
			String cpf, 
			Set<Contact> contacts) {
		this.name = name;
		this.addresses = addresses;
		this.email = email;
		this.cpf = cpf;
		this.contacts = contacts;
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", cpf=" + cpf + "]";
	}
}
