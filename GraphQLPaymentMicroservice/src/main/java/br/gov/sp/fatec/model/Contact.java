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

import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.contact.CreatekafkaContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateKafkaContactDto;

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
	
	@Column(name = "id_user_contact")
	private String userContactId;
	
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
			String value,
			String userContactId) {
		this.title = title;
		this.type = type;
		this.value = value;
		this.userContactId = userContactId;
	}

	public Contact(CreateContactDto dto) {
		this.title = dto.getTitle();
		this.type = dto.getType();
		this.value = dto.getValue();
	}

	public Contact(CreatekafkaContactDto dto) {
		this.userContactId = dto.getUserContactId();
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

	public String getUserContactId() {
		return userContactId;
	}

	public void setUserContactId(String userContactId) {
		this.userContactId = userContactId;
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
	
	public Contact updateEntity(UpdateContactDto dto) {
		this.title = dto.getTitle() != "" ? dto.getTitle() : this.title;
		this.type = dto.getType() != "" ? dto.getType() : this.type;
		this.value = dto.getValue() != "" ? dto.getValue() : this.value;
		return this;
	}
	
	public Contact updateEntity(UpdateKafkaContactDto dto) {
		this.userContactId = dto.getUserContactId();
		this.title = dto.getTitle() != "" ? dto.getTitle() : this.title;
		this.type = dto.getType() != "" ? dto.getType() : this.type;
		this.value = dto.getValue() != "" ? dto.getValue() : this.value;
		return this;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id +
				", userContactId=" + userContactId +
				", title=" + title + 
				", type=" + type + 
				", value=" + value + "]";
	}
}
