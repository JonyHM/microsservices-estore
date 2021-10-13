package br.gov.sp.fatec.model.dto.order;

import java.util.UUID;

public class OrderManagementDto {

	private UUID orderId;
	private UUID cartId;
	private UUID cardId;
	
	public OrderManagementDto() {}

	public OrderManagementDto(
			UUID orderId,
			UUID cartId,
			UUID cardId) {
		this.orderId = orderId;
		this.cartId = cartId;
		this.cardId = cardId;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public UUID getCardId() {
		return cardId;
	}

	public void setCardId(UUID cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "PayOrderDto [orderId=" + orderId +
				", cartId=" + cartId +
				", cardId=" + cardId + "]";
	}
	
}
