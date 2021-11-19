package br.gov.sp.fatec.model.paymentMicroservice.price.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class CreatePriceData {

	private PriceDto createPrice;
	
	public CreatePriceData() {}

	public CreatePriceData(PriceDto createPrice) {
		this.createPrice = createPrice;
	}

	public PriceDto getCreatePrice() {
		return createPrice;
	}

	public void setCreatePrice(PriceDto createPrice) {
		this.createPrice = createPrice;
	}

	@Override
	public String toString() {
		return "CreatePriceData [createPrice=" + createPrice + "]";
	}
	
}
