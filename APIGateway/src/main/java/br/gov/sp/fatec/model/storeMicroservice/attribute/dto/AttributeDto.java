package br.gov.sp.fatec.model.storeMicroservice.attribute.dto;

import java.util.UUID;

public class AttributeDto {

	private UUID id;
	private String name;
	private String value;
	
	public AttributeDto() {}

	public AttributeDto(
			UUID id, 
			String name, 
			String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		return "AttributeDto [id=" + id + 
				", name=" + name + 
				", value=" + value + "]";
	}
	
}
