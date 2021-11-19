package br.gov.sp.fatec.model.paymentMicroservice.price.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class GetPriceByOrderIdData {

	private PriceDto getPriceByOrderId;
	
	public GetPriceByOrderIdData() {}

	public GetPriceByOrderIdData(PriceDto getPriceByOrderId) {
		this.getPriceByOrderId = getPriceByOrderId;
	}

	public PriceDto getGetPriceByOrderId() {
		return getPriceByOrderId;
	}

	public void setGetPriceByOrderId(PriceDto getPriceByOrderId) {
		this.getPriceByOrderId = getPriceByOrderId;
	}

	@Override
	public String toString() {
		return "GetPriceByOrderIdData [getPriceByOrderId=" + getPriceByOrderId + "]";
	}
	
}
