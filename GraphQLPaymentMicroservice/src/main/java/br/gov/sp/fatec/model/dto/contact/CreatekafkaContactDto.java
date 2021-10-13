package br.gov.sp.fatec.model.dto.contact;

import java.util.UUID;

public class CreatekafkaContactDto {

	private UUID userContactId;
	private UUID userId;
	private String title;
	private String type;
	private String value;
	
	public CreatekafkaContactDto() {}

	public CreatekafkaContactDto(
			UUID userContactId,
			UUID userId,
			String title, 
			String type, 
			String value) {
		this.userContactId = userContactId;
		this.userId = userId;
		this.title = title;
		this.type = type;
		this.value = value;
	}

	public UUID getUserContactId() {
		return userContactId;
	}

	public void setUserContactId(UUID userContactId) {
		this.userContactId = userContactId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
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

	@Override
	public String toString() {
		return "CreatekafkaContactDto [userContactId=" + userContactId + 
				", userId=" + userId + 
				", title=" + title + 
				", type=" + type +
				", value=" + value + "]";
	}
	
}
