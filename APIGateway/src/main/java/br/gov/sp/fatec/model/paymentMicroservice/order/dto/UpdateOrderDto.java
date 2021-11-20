package br.gov.sp.fatec.model.paymentMicroservice.order.dto;

import java.util.UUID;

public class UpdateOrderDto {
	
	private UUID orderId;
	private String description;
	
	public UpdateOrderDto() {}

	public UpdateOrderDto(
			UUID orderId, 
			String description) {
		this.orderId = orderId;
		this.description = description;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UpdateOrderDto [orderId=" + orderId + 
				", description=" + description + "]";
	}
	
}
