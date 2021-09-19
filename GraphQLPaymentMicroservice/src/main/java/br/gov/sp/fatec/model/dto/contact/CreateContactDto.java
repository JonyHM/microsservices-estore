package br.gov.sp.fatec.model.dto.contact;

import java.util.UUID;

public class CreateContactDto {

	private String title;
	private String type;
	private String value;
	private UUID customerId;
	
	public CreateContactDto() {}

	public CreateContactDto(
			String title, 
			String type, 
			String value, 
			UUID customerId) {
		this.title = title;
		this.type = type;
		this.value = value;
		this.customerId = customerId;
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

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CreateContactDto [title=" + title + ", type=" + type + ", value=" + value + ", customerId=" + customerId
				+ "]";
	}
	
}
