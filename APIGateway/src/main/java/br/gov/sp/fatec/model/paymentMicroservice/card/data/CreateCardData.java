package br.gov.sp.fatec.model.paymentMicroservice.card.data;

import br.gov.sp.fatec.model.paymentMicroservice.card.dto.CardDto;

public class CreateCardData {

	private CardDto createCard;
	
	public CreateCardData() {}

	public CreateCardData(CardDto createCard) {
		this.createCard = createCard;
	}

	public CardDto getCreateCard() {
		return createCard;
	}

	public void setCreateCard(CardDto createCard) {
		this.createCard = createCard;
	}

	@Override
	public String toString() {
		return "CreateCardData [createCard=" + createCard + "]";
	}
	
}
