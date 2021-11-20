package br.gov.sp.fatec.model.orderMicroservice.cart;

import java.util.UUID;

public class RemoveProductDto {

	private UUID cartId;
	private UUID productId;
	
	public RemoveProductDto() {}

	public RemoveProductDto(
			UUID cartId, 
			UUID productId) {
		this.cartId = cartId;
		this.productId = productId;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "RemoveProductDto [cartId=" + cartId + 
				", productId=" + productId + "]";
	}
	
}
