package br.gov.sp.fatec.model.paymentMicroservice.card.data;

import br.gov.sp.fatec.model.paymentMicroservice.card.dto.CardDto;

public class GetCardByIdData {

	private CardDto getCardById;
	
	public GetCardByIdData() {}

	public GetCardByIdData(CardDto getCardById) {
		this.getCardById = getCardById;
	}

	public CardDto getGetCardById() {
		return getCardById;
	}

	public void setGetCardById(CardDto getCardById) {
		this.getCardById = getCardById;
	}

	@Override
	public String toString() {
		return "GetCardByIdData [getCardById=" + getCardById + "]";
	}
		
}
