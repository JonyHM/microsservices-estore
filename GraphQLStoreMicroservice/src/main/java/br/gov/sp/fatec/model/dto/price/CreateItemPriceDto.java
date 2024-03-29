package br.gov.sp.fatec.model.dto.price;

public class CreateItemPriceDto {

	private String currency;
	private Double amount;
	
	public CreateItemPriceDto() {}

	public CreateItemPriceDto(String currency, Double amount) {
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
		return "CreateItemPriceDto [currency=" + currency + 
				", amount=" + amount + "]";
	}
	
}
