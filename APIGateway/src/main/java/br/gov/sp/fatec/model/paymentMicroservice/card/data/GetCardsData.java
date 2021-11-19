package br.gov.sp.fatec.model.paymentMicroservice.card.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.card.dto.CardDto;

public class GetCardsData {

	private Set<CardDto> getCards;
	
	public GetCardsData() {}

	public GetCardsData(Set<CardDto> getCards) {
		this.getCards = getCards;
	}

	public Set<CardDto> getGetCards() {
		return getCards;
	}

	public void setGetCards(Set<CardDto> getCards) {
		this.getCards = getCards;
	}

	@Override
	public String toString() {
		return "GetCardsData [getCards=" + getCards + "]";
	}
	
}
