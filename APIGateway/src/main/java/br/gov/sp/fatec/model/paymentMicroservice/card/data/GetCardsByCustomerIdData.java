package br.gov.sp.fatec.model.paymentMicroservice.card.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.card.dto.CardDto;

public class GetCardsByCustomerIdData {

	private Set<CardDto> getCardsByCustomerId;
	
	public GetCardsByCustomerIdData() {}

	public GetCardsByCustomerIdData(Set<CardDto> getCardsByCustomerId) {
		this.getCardsByCustomerId = getCardsByCustomerId;
	}

	public Set<CardDto> getGetCardsByCustomerId() {
		return getCardsByCustomerId;
	}

	public void setGetCardsByCustomerId(Set<CardDto> getCardsByCustomerId) {
		this.getCardsByCustomerId = getCardsByCustomerId;
	}

	@Override
	public String toString() {
		return "GetCardsByCustomerIdData [getCardsByCustomerId=" + getCardsByCustomerId + "]";
	}
	
}
