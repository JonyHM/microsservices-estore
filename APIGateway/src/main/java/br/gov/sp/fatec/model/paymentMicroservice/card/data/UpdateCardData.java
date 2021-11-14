package br.gov.sp.fatec.model.paymentMicroservice.card.data;

import br.gov.sp.fatec.model.paymentMicroservice.card.dto.CardDto;

public class UpdateCardData {

	private CardDto updateCard;
	
	public UpdateCardData() {}

	public UpdateCardData(CardDto updateCard) {
		this.updateCard = updateCard;
	}

	public CardDto getUpdateCard() {
		return updateCard;
	}

	public void setUpdateCard(CardDto updateCard) {
		this.updateCard = updateCard;
	}

	@Override
	public String toString() {
		return "UpdateCardData [updateCard=" + updateCard + "]";
	}
	
}
