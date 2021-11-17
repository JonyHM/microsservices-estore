package br.gov.sp.fatec.model.storeMicroservice.product.dto;

import br.gov.sp.fatec.model.storeMicroservice.price.dto.CreateStorePriceDto;

public class CreateProductDto {

	private String name;
	private String description;
	private Long quantity;
	private Long unavailableQuantity;
    private CreateStorePriceDto price;
    
    public CreateProductDto() {}

	public CreateProductDto(
			String name, 
			String description, 
			Long quantity, 
			Long unavailableQuantity, 
			CreateStorePriceDto price) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.unavailableQuantity = unavailableQuantity;
		this.price = price;
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

	public CreateStorePriceDto getPrice() {
		return price;
	}

	public void setPrice(CreateStorePriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CreateProductDto [name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + 
				", unavailableQuantity=" + unavailableQuantity + 
				", price=" + price + "]";
	}
    
}
