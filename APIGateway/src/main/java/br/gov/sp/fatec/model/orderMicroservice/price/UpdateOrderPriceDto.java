package br.gov.sp.fatec.model.orderMicroservice.price;

import java.util.UUID;

public class UpdateOrderPriceDto {

    private UUID id;
    private String currency;
    private String amount;

    public UpdateOrderPriceDto() {}

	public UpdateOrderPriceDto(
			UUID id, 
			String currency, 
			String amount) {
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "UpdateOrderPriceDto [id=" + id + 
				", currency=" + currency + 
				", amount=" + amount + "]";
	}
    
}
