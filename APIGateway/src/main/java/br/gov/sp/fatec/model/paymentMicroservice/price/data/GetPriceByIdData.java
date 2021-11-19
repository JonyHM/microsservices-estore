package br.gov.sp.fatec.model.paymentMicroservice.price.data;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class GetPriceByIdData {

	private PriceDto getPriceById;
	
	public GetPriceByIdData() {}

	public GetPriceByIdData(PriceDto getPriceById) {
		this.getPriceById = getPriceById;
	}

	public PriceDto getGetPriceById() {
		return getPriceById;
	}

	public void setGetPriceById(PriceDto getPriceById) {
		this.getPriceById = getPriceById;
	}

	@Override
	public String toString() {
		return "GetPriceByIdData [getPriceById=" + getPriceById + "]";
	}
	
}
