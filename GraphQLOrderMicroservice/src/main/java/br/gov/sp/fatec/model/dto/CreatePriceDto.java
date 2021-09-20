package br.gov.sp.fatec.model.dto;

public class CreatePriceDto {

	private String currency;
	private Double amount;
	
	public CreatePriceDto() {}

	public CreatePriceDto(
			String currency, 
			Double amount) {
		this.currency = currency;
		this.amount = amount;
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
		return "CreatePriceDto [currency=" + currency + 
				", amount=" + amount + "]";
	}
	
}
