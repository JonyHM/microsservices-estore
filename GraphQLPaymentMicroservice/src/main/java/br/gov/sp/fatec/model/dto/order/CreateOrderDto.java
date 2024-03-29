package br.gov.sp.fatec.model.dto.order;

import br.gov.sp.fatec.model.dto.price.CreateOrderPriceDto;

public class CreateOrderDto {

	private String cartId;	
	private String userId;	
	private String description;
	private CreateOrderPriceDto price;
	
	public CreateOrderDto() {}

	public CreateOrderDto(
			String cartId, 
			String userId,
			String description,
			CreateOrderPriceDto price) {
		this.cartId = cartId;
		this.userId = userId;
		this.description = description;
		this.price = price;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "OrderDto [cart id=" + cartId + 
				", user id=" + userId + 
				", description=" + description + 
				", price=" + price + "]";
	}
	
}
