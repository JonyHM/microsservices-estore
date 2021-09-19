package br.gov.sp.fatec.model.dto.price;

import java.util.UUID;

public class UpdatePriceDto {

	private UUID priceId;
	private String currency;
	private Double amount;
	private UUID productId;
	
	public UpdatePriceDto() {}

	public UpdatePriceDto(
			UUID priceId, 
			String currency, 
			Double amount, 
			UUID productId) {
		this.priceId = priceId;
		this.currency = currency;
		this.amount = amount;
		this.productId = productId;
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

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "UpdatePriceDto [priceId=" + priceId + ", currency=" + currency + ", amount=" + amount + ", productId="
				+ productId + "]";
	}

}
