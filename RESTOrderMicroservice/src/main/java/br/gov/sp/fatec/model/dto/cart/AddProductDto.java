package br.gov.sp.fatec.model.dto.cart;

import java.util.UUID;

import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;

public class AddProductDto {

	private CreateOrderProductDto product; 
	private UUID cartId;
	
	public AddProductDto() {}

	public AddProductDto(
			CreateOrderProductDto product, 
			UUID cartId) {
		this.product = product;
		this.cartId = cartId;
	}

	public CreateOrderProductDto getProduct() {
		return product;
	}

	public void setProduct(CreateOrderProductDto product) {
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
