package br.gov.sp.fatec.model.dto.contact;

import java.util.UUID;

public class UpdateKafkaContactDto {

	private UUID userId;
	private String userContactId;
	private String title;
	private String type;
	private String value;
	
	public UpdateKafkaContactDto() {}

	public UpdateKafkaContactDto(
			UUID userId, 
			String userContactId,
			String title, 
			String type, 
			String value) {
		this.userId = userId;
		this.userContactId = userContactId;
		this.title = title;
		this.type = type;
		this.value = value;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "UpdateKafkaContactDto [userId=" + userId + 
				", userContactId=" + userContactId +
				", title=" + title + 
				", type=" + type + 
				", value=" + value + "]";
	}
	
}
