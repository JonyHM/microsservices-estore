package br.gov.sp.fatec.model.dto.orderProduct;

import br.gov.sp.fatec.model.OrderProduct;

public class ProductDto {

	private String productId;
	private Long quantity;
	
	public ProductDto() {}
	
	public ProductDto(OrderProduct product) {
		this.productId = product.getProductId();
		this.quantity = product.getQuantity();
	}

	public ProductDto(String productId, Long quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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
		return "ProductDto [productId=" + productId + 
				", quantity=" + quantity + "]";
	}
		
}
