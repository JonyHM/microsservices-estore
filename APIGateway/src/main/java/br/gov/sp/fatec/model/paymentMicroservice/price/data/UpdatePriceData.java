package br.gov.sp.fatec.model.paymentMicroservice.price.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class UpdatePriceData {

	private PriceDto updatePrice;
	
	public UpdatePriceData() {}

	public UpdatePriceData(PriceDto updatePrice) {
		this.updatePrice = updatePrice;
	}

	public PriceDto getUpdatePrice() {
		return updatePrice;
	}

	public void setUpdatePrice(PriceDto updatePrice) {
		this.updatePrice = updatePrice;
	}

	@Override
	public String toString() {
		return "UpdatePriceData [updatePrice=" + updatePrice + "]";
	}
	
}
