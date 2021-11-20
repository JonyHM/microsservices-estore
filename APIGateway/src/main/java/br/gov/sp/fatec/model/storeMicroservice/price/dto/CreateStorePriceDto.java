package br.gov.sp.fatec.model.storeMicroservice.price.dto;

import java.util.UUID;

public class CreateStorePriceDto {

	private String currency;
    private Double amount;
    private UUID productId;
    
    public CreateStorePriceDto() {}

	public CreateStorePriceDto(
			String currency, 
			Double amount,
			UUID productId) {
		this.currency = currency;
		this.amount = amount;
		this.productId = productId;
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
		return "CreateStorePriceDto [currency=" + currency + 
				", amount=" + amount + 
				", productId=" + productId + "]";
	}

}
