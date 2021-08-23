package br.gov.sp.fatec.model;

import java.rmi.server.UID;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
public class Customer {

	@Id
	@Column(name = "id_customer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UID id;
	
	@Column(length = 40)
	private String name;
	
	@Column(length = 14)
    @Pattern(
    	regexp="([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
    	message="formato de documento inválido"
    )  
	private String cpf;
	
	@OneToMany(
    	mappedBy = "customer",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Contact> contacts = new HashSet<Contact>();
	
	@OneToMany(
    	mappedBy = "customer",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Address> addresses = new HashSet<Address>();
	
	@OneToMany(
    	mappedBy = "holder",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Card> cards = new HashSet<Card>();
	
	public Customer() {}

	public Customer(UID id, String name,
			@Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})", 
			message = "formato de documento inválido") String cpf) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	}

	public UID getId() {
		return id;
	}

	public void setId(UID id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + 
				", name=" + name + 
				", cpf=" + cpf + "]";
	}
	
	
}
