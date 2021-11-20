package br.gov.sp.fatec.model.userMicroservice.contact.dto;

import java.util.UUID;

public class ContactDto {

	private UUID id;	
	private String title;	
	private String type;	
	private String value;
	
	public ContactDto() {}

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

	@Override
	public String toString() {
		return "ContactDto [id=" + id + 
				", title=" + title + 
				", type=" + type + 
				", value=" + value + "]";
	}
	
}
