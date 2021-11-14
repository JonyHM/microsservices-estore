package br.gov.sp.fatec.model.paymentMicroservice.order.dto;

public class CreateOrderDto {

	private String cartId;
	private String userId;
	private String description;
	private PriceDto price;
	
	public CreateOrderDto() {}

	public CreateOrderDto(
			String cartId, 
			String userId, 
			String description, 
			PriceDto price) {
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

	public PriceDto getPrice() {
		return price;
	}

	public void setPrice(PriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CreateOrderDto [cartId=" + cartId + 
				", userId=" + userId + 
				", description=" + description + 
				", price=" + price + "]";
	}
	
}
