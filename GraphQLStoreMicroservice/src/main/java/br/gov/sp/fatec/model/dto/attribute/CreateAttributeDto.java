package br.gov.sp.fatec.model.dto.attribute;

import java.util.UUID;

public class CreateAttributeDto {

	private String name;
	private String value;
	private UUID productId;
	
	public CreateAttributeDto() {}
	
	public CreateAttributeDto(String name, String value, UUID productId) {
		this.name = name;
		this.value = value;
		this.productId = productId;
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

	@Override
	public String toString() {
		return "CreateAttributeDto [name=" + name + ", value=" + value + ", productId=" + productId + "]";
	}
	
}
