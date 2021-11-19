package br.gov.sp.fatec.model.paymentMicroservice.price.dto;

import java.util.UUID;

public class CreatePriceDto {

	private String currency;
    private Double amount;
    private UUID orderId;
    
    public CreatePriceDto() {}

	public CreatePriceDto(
			String currency, 
			Double amount, 
			UUID orderId) {
		this.currency = currency;
		this.amount = amount;
		this.orderId = orderId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public UUID getOrderId() {
		return orderId;
	}

	public void setOrderId(UUID orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "CreatePriceDto [currency=" + currency + 
				", amount=" + amount + 
				", orderId=" + orderId + "]";
	}
    
}
