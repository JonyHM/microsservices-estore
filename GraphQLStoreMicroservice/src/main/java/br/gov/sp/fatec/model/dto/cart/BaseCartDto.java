package br.gov.sp.fatec.model.dto.cart;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.dto.product.ProductDto;

public class BaseCartDto {
	
	private UUID userId;
	private UUID cartId;
	private Set<ProductDto> products;
	
	public BaseCartDto() {}

	public BaseCartDto(
			UUID userId, 
			UUID cartId, 
			Set<ProductDto> products) {
		this.userId = userId;
		this.cartId = cartId;
		this.products = products;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "BaseCartDto [userId=" + userId + 
				", cartId=" + cartId + 
				", products=" + products + "]";
	}
	
}
