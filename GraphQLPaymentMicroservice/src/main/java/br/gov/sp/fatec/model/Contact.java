package br.gov.sp.fatec.model;

import java.rmi.server.UID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	@Id
	@Column(name = "id_contact")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UID id;
	
	@Column(length = 50)
	private String title;
	
	@Column(length = 10)
	private String type;
	
	@Column(length = 50)
	private String value;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_contact_customer")
	private Customer customer;
	
	public Contact() {}

	public Contact(String title, 
			String type, 
			String value, 
			Customer customer) {
		this.title = title;
		this.type = type;
		this.value = value;
		this.customer = customer;
	}

	public UID getId() {
		return id;
	}

	public void setId(UID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + 
				", title=" + title + 
				", type=" + type + 
				", value=" + value + "]";
	}
}
