package br.gov.sp.fatec.model.orderMicroservice.cart;

import java.util.UUID;

import br.gov.sp.fatec.model.orderMicroservice.product.CreateProductDto;

public class AddProductDto {

	private CreateProductDto product; 
	private UUID cartId;
	
	public AddProductDto() {}

	public AddProductDto(
			CreateProductDto product, 
			UUID cartId) {
		this.product = product;
		this.cartId = cartId;
	}

	public CreateProductDto getProduct() {
		return product;
	}

	public void setProduct(CreateProductDto product) {
		this.product = product;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "AddProductDto [product=" + product + 
				", cartId=" + cartId + "]";
	}
	
}
