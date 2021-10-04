package br.gov.sp.fatec.model.dto.price;

import java.util.UUID;

public class UpdatePriceDto {

	private UUID priceId;
	private String currency;
	private Double amount;
	
	public UpdatePriceDto() {}

	public UpdatePriceDto(
			UUID priceId, 
			String currency, 
			Double amount) {
		this.priceId = priceId;
		this.currency = currency;
		this.amount = amount;
	}

	public UUID getPriceId() {
		return priceId;
	}

	public void setPriceId(UUID priceId) {
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

	@Override
	public String toString() {
		return "UpdatePriceDto [priceId=" + priceId + 
				", currency=" + currency + 
				", amount=" + amount + "]";
	}

}
