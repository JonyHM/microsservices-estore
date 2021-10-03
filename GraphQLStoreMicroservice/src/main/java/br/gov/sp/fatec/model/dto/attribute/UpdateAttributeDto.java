package br.gov.sp.fatec.model.dto.attribute;

import java.util.UUID;

public class UpdateAttributeDto {

	private UUID attributeId;
	private String name;
	private String value;
	
	public UpdateAttributeDto() {}

	public UpdateAttributeDto(
			UUID attributeId, 
			String name, 
			String value) {
		this.attributeId = attributeId;
		this.name = name;
		this.value = value;
	}

	public UUID getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(UUID attributeId) {
		this.attributeId = attributeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "UpdateAttributeDto [attributeId=" + attributeId + 
				", name=" + name + 
				", value=" + value + "]";
	}
	
}
