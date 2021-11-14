package br.gov.sp.fatec.model.dto.order;

import java.util.UUID;

import br.gov.sp.fatec.model.dto.price.CreateOrderPriceDto;

public class StartOrderDto {

	private String userId;
	private UUID cartId;
	private CreateOrderPriceDto price;
	private String description;
	
	public StartOrderDto() {}

	public StartOrderDto(
			String userId,
			UUID cartId,
			String description, 
			CreateOrderPriceDto price) {
		this.userId = userId;
		this.cartId = cartId;
		this.description = description;
		this.price = price;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CreateOrderPriceDto getPrice() {
		return price;
	}

	public void setPrice(CreateOrderPriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StartOrderDto [userId=" + userId + 
				", cartId=" + cartId +
				", price=" + price + 
				", description=" + description + "]";
	}
}
