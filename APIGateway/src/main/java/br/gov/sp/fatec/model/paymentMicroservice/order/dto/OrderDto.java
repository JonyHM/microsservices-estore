package br.gov.sp.fatec.model.paymentMicroservice.order.dto;

import java.util.UUID;

public class OrderDto {

	private UUID id;
	private UUID cartId;
	private String userId;
	private String description;
	private String status;
	private PriceDto price;
	
	public OrderDto() {}

	public OrderDto(
			UUID id, 
			UUID cartId, 
			String userId, 
			String description, 
			String status,
			PriceDto price) {
		this.id = id;
		this.cartId = cartId;
		this.userId = userId;
		this.description = description;
		this.status = status;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PriceDto getPrice() {
		return price;
	}

	public void setPrice(PriceDto price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "GetOrdersDto [id=" + id + 
				", cartId=" + cartId + 
				", userId=" + userId + 
				", description=" + description + 
				", status=" + status + 
				", price=" + price + "]";
	}
	
}
