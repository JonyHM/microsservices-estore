package br.gov.sp.fatec.model.orderMicroservice.product;

import java.util.UUID;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class ProductDto {

	private UUID id;
	private UUID productId;
	private String name;
	private String description;
	private Long quantity;
	private PriceDto price;
	
	public ProductDto() {}

	public ProductDto(
			UUID id, 
			UUID productId, 
			String name, 
			String description, 
			Long quantity, 
			PriceDto price) {
		this.id = id;
		this.productId = productId;
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

	public PriceDto getPrice() {
		return price;
	}

	public void setPrice(PriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + 
				", productId=" + productId + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + 
				", price=" + price + "]";
	}
	
}
