package br.gov.sp.fatec.model.dto.contact;

public class CreatekafkaContactDto {

	private String userContactId;
	private String userId;
	private String title;
	private String type;
	private String value;
	
	public CreatekafkaContactDto() {}

	public CreatekafkaContactDto(
			String userContactId,
			String userId,
			String title, 
			String type, 
			String value) {
		this.userContactId = userContactId;
		this.userId = userId;
		this.title = title;
		this.type = type;
		this.value = value;
	}

	public String getUserContactId() {
		return userContactId;
	}

	public void setUserContactId(String userContactId) {
		this.userContactId = userContactId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
