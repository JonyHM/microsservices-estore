package br.gov.sp.fatec.model.storeMicroservice.price.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class GetPriceByProductIdData {

	private PriceDto getPriceByProductId;
	
	public GetPriceByProductIdData() {}

	public GetPriceByProductIdData(PriceDto getPriceByProductId) {
		this.getPriceByProductId = getPriceByProductId;
	}

	public PriceDto getGetPriceByProductId() {
		return getPriceByProductId;
	}

	public void setGetPriceByProductId(PriceDto getPriceByProductId) {
		this.getPriceByProductId = getPriceByProductId;
	}

	@Override
	public String toString() {
		return "GetPriceByProductIdData [getPriceByProductId=" + getPriceByProductId + "]";
	}
	
}
