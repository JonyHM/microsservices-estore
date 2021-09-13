package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.CreateContactDto;

@Entity
public class Contact {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_contact", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
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

	public Contact(
			String title, 
			String type, 
			String value) {
		this.title = title;
		this.type = type;
		this.value = value;
	}

	public Contact(CreateContactDto dto) {
		this.title = dto.getTitle();
		this.type = dto.getType();
		this.value = dto.getValue();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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
