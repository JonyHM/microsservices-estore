package br.gov.sp.fatec.model.paymentMicroservice.price.dto;

import java.util.UUID;

public class UpdatePriceDto {

	private String currency;
    private Double amount;
    private UUID priceId;
    
    public UpdatePriceDto() {}

	public UpdatePriceDto(
			String currency, 
			Double amount, 
			UUID priceId) {
		this.currency = currency;
		this.amount = amount;
		this.priceId = priceId;
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

	public UUID getPriceId() {
		return priceId;
	}

	public void setPriceId(UUID priceId) {
		this.priceId = priceId;
	}

	@Override
	public String toString() {
		return "UpdatePriceDto [currency=" + currency + 
				", amount=" + amount + 
				", priceId=" + priceId + "]";
	}
    
}
