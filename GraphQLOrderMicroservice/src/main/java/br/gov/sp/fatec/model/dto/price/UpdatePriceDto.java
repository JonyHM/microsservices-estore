package br.gov.sp.fatec.model.dto.price;

import java.util.UUID;

public class UpdatePriceDto {

	private UUID id;
	private String currency;
	private Double amount;
	
	public UpdatePriceDto() {}

	public UpdatePriceDto(
			UUID id, 
			String currency, 
			Double amount) {
		this.id = id;
		this.currency = currency;
		this.amount = amount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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
		return "UpdatePriceDto [id=" + id + 
				", currency=" + currency + 
				", amount=" + amount + "]";
	}
	
}
