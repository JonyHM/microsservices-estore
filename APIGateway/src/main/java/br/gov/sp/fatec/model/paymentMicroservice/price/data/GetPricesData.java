package br.gov.sp.fatec.model.paymentMicroservice.price.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class GetPricesData {

	private Set<PriceDto> getPricesData;
	
	public GetPricesData() {}

	public GetPricesData(Set<PriceDto> getPricesData) {
		this.getPricesData = getPricesData;
	}

	public Set<PriceDto> getGetPricesData() {
		return getPricesData;
	}

	public void setGetPricesData(Set<PriceDto> getPricesData) {
		this.getPricesData = getPricesData;
	}

	@Override
	public String toString() {
		return "GetPricesData [getPricesData=" + getPricesData + "]";
	}
	
}
