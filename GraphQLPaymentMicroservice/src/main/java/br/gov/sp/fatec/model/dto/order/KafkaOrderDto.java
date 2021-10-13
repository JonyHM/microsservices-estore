package br.gov.sp.fatec.model.dto.order;

import java.util.UUID;

public class KafkaOrderDto {

	private UUID cartId;
	private UUID orderId;
	
	public KafkaOrderDto() {}

	public KafkaOrderDto(
			UUID cartId, 
			UUID orderId) {
		this.cartId = cartId;
		this.orderId = orderId;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "kafkaTopicOrderDto [cartId=" + cartId + 
				", orderId=" + orderId + "]";
	}
	
}
