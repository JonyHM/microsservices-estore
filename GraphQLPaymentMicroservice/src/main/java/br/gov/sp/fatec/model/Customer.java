package br.gov.sp.fatec.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.customer.CreateCustomerDto;
import br.gov.sp.fatec.model.dto.customer.UpdateCustomerDto;

@Entity
public class Customer {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_customer", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(unique = true, name = "id_user")
	private UUID userId;
	
	@Column(length = 40)
	private String name;
	
	
	@Column(unique = true, length = 14)
    @Pattern(
    	regexp="([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
    	message="formato de documento inválido"
    )  
	private String cpf;
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
    	mappedBy = "customer",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
    	mappedBy = "customer",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
    	mappedBy = "holder",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Card> cards = new HashSet<Card>();
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
    	mappedBy = "customer",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Order> orders = new HashSet<Order>();
	
	public Customer() {}

	public Customer(UUID userId, String name,
			@Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
			message = "formato de documento inválido") String cpf) {
		this.userId = userId;
		this.name = name;
		this.cpf = cpf;
	}
	
	public Customer(CreateCustomerDto dto) {
		this.userId = dto.getUserId();
		this.name = dto.getName();
		this.cpf = dto.getCpf();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<Card> getCards() {
		return cards;
	}

	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public Customer updateEntity(UpdateCustomerDto dto) {
		this.name = dto.getName() != "" ? dto.getName() : this.name;
		this.cpf = dto.getCpf() != "" ? dto.getCpf() : this.cpf;
		return this;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id +
				", user id=" + userId +
				", name=" + name + 
				", cpf=" + cpf + "]";
	}
	
	
}
