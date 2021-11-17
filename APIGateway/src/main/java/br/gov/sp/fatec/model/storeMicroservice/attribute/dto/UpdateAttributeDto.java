package br.gov.sp.fatec.model.storeMicroservice.attribute.dto;

import java.util.UUID;

public class UpdateAttributeDto {

	private String name;
	private String value;
	private UUID productId;
	private UUID attributeId;
	
	public UpdateAttributeDto() {}

	public UpdateAttributeDto(
			String name, 
			String value, 
			UUID productId, 
			UUID attributeId) {
		this.name = name;
		this.value = value;
		this.productId = productId;
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

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public UUID getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(UUID attributeId) {
		this.attributeId = attributeId;
	}

	@Override
	public String toString() {
		return "UpdateAttributeDto [name=" + name + 
				", value=" + value + 
				", productId=" + productId + 
				", attributeId=" + attributeId + "]";
	}
	
}
