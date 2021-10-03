package br.gov.sp.fatec.model.dto.product;

import java.util.UUID;

public class ProductDto {

	private UUID productId;
	private Long quantity;
	
	public ProductDto() {}

	public ProductDto(UUID productId, Long quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", quantity=" + quantity + "]";
	}
		
}
