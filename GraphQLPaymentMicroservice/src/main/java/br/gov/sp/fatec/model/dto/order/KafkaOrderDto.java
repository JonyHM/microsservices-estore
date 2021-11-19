package br.gov.sp.fatec.model.dto.order;

import java.util.UUID;

public class KafkaOrderDto {

	private String cartId;
	private UUID orderId;
	
	public KafkaOrderDto() {}

	public KafkaOrderDto(
			String cartId, 
			UUID orderId) {
		this.cartId = cartId;
		this.orderId = orderId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
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
