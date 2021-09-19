package br.gov.sp.fatec.model.dto.product;

public class CreateProductDto {

	private String name;
	private String description;
	private Long quantity;
	private Long unavailableQuantity;
	
	public CreateProductDto() {}
	
	public CreateProductDto(String name, String description, Long quantity, Long unavailableQuantity) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.unavailableQuantity = unavailableQuantity;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	public Long getUnavailableQuantity() {
		return unavailableQuantity;
	}

	public void setUnavailableQuantity(Long unavailableQuantity) {
		this.unavailableQuantity = unavailableQuantity;
	}

	@Override
	public String toString() {
		return "CreateProductDto [name=" + name + 
				", description=" + description +
				", unavailableQuantity=" + unavailableQuantity +
				", quantity=" + quantity + "]";
	}
}
