package br.gov.sp.fatec.model.dto;

import java.util.UUID;

public class CreateOrderDto {

	private UUID cartId;
	
	private UUID userId;
	
	private String description;
	
	public CreateOrderDto() {}

	public CreateOrderDto(
			UUID cartId, 
			UUID userId,
			String description) {
		this.cartId = cartId;
		this.userId = userId;
		this.description = description;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "OrderDto [cart id=" + cartId + ", user id=" + userId + ", description=" + description + "]";
	}
	
}
