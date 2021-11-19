package br.gov.sp.fatec.model.orderMicroservice.product;

import java.util.UUID;

import br.gov.sp.fatec.model.orderMicroservice.price.CreateOrderPriceDto;

public class UpdateProductDto {

	private UUID id;
	private String name;
	private String description;
	private Long quantity;
	private CreateOrderPriceDto price;
	
	public UpdateProductDto() {}

	public UpdateProductDto(
			UUID id, 
			String name, 
			String description, 
			Long quantity, 
			CreateOrderPriceDto price) {
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

	public CreateOrderPriceDto getPrice() {
		return price;
	}

	public void setPrice(CreateOrderPriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "UpdateProductDto [id=" + id + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + 
				", price=" + price + "]";
	}
	
}
