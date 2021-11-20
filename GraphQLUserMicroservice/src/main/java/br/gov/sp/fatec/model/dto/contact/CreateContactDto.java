package br.gov.sp.fatec.model.dto.contact;

import java.util.UUID;

import br.gov.sp.fatec.model.Contact;

public class CreateContactDto {

	private String title;
	private String type;
	private String value;
	private UUID userId;
	
	public CreateContactDto() {}
	
	public CreateContactDto(Contact contact) {
		this.title = contact.getTitle();
		this.type = contact.getType();
		this.value = contact.getValue();
		this.userId = contact.getUser().getId();
	}

	public CreateContactDto(
			String title, 
			String type, 
			String value, 
			UUID userId) {
		this.title = title;
		this.type = type;
		this.value = value;
		this.userId = userId;
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

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CreateContactDto [title=" + title + ", type=" + type + ", value=" + value + ", userId=" + userId + "]";
	}
	
}
