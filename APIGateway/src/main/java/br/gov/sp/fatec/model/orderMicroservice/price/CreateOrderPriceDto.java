package br.gov.sp.fatec.model.orderMicroservice.price;

public class CreateOrderPriceDto {

	private String currency;
    private Double amount;
    
    public CreateOrderPriceDto() {}

	public CreateOrderPriceDto(
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
		return "CreateOrderPriceDto [currency=" + currency + 
				", amount=" + amount + "]";
	}
    
}
