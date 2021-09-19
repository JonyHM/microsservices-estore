package br.gov.sp.fatec.model.dto.contact;

import java.util.UUID;

public class UpdateContactDto {

	private UUID contactId;
	private String title;
	private String type;
	private String value;
	
	public UpdateContactDto() {}

	public UpdateContactDto(
			UUID contactId, 
			String title, 
			String type, 
			String value) {
		this.contactId = contactId;
		this.title = title;
		this.type = type;
		this.value = value;
	}

	public UUID getContactId() {
		return contactId;
	}

	public void setContactId(UUID contactId) {
		this.contactId = contactId;
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
		return "UpdateContactDto [contactId=" + contactId + 
				", title=" + title + 
				", type=" + type + 
				", value=" + value + "]";
	}
	
}
