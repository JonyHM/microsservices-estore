package br.gov.sp.fatec.model.dto.orderProduct;

import java.util.UUID;

import br.gov.sp.fatec.model.dto.price.CreatePriceDto;

public class UpdateOrderProductDto {

	private UUID id;
	private String name;
	private String description;
	private Long quantity;
	private CreatePriceDto price;
	
	public UpdateOrderProductDto() {}

	public UpdateOrderProductDto(
			UUID id, 
			String name, 
			String description, 
			Long quantity, 
			CreatePriceDto price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
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

	public CreatePriceDto getPrice() {
		return price;
	}

	public void setPrice(CreatePriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "UpdateOrderProductDto [id=" + id + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + "]";
	}
	
}
