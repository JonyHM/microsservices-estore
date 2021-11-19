package br.gov.sp.fatec.model.storeMicroservice.product.dto;

import java.util.UUID;

import br.gov.sp.fatec.model.storeMicroservice.price.dto.CreateStorePriceDto;

public class UpdateProductDto {

	private UUID id;
	private String name;
	private String description;
	private Long quantity;
	private Long unavailableQuantity;
    private CreateStorePriceDto price;
    
    public UpdateProductDto() {}

	public UpdateProductDto(
			UUID id, 
			String name, 
			String description, 
			Long quantity, 
			Long unavailableQuantity,
			CreateStorePriceDto price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.unavailableQuantity = unavailableQuantity;
		this.price = price;
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
		return "UpdateProductDto [id=" + id + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + 
				", unavailableQuantity=" + unavailableQuantity + 
				", price=" + price + "]";
	}
    
}
