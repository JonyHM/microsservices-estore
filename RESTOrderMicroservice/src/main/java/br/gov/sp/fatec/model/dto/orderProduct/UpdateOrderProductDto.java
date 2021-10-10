package br.gov.sp.fatec.model.dto.orderProduct;

import java.util.UUID;

import br.gov.sp.fatec.model.dto.price.CreatePriceDto;

public class UpdateOrderProductDto {

	private UUID productId;
	private String name;
	private String description;
	private Long quantity;
	private CreatePriceDto price;
	
	public UpdateOrderProductDto() {}

	public UpdateOrderProductDto(
			UUID productId, 
			String name, 
			String description, 
			Long quantity, 
			CreatePriceDto price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
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
		return "UpdateOrderProductDto [productId=" + productId + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + "]";
	}
	
}
