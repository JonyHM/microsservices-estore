package br.gov.sp.fatec.model.paymentMicroservice.card.data;

public class DeleteCardData {

	private String deleteCard;
	
	public DeleteCardData() {}

	public DeleteCardData(String deleteCard) {
		this.deleteCard = deleteCard;
	}

	public String getDeleteCard() {
		return deleteCard;
	}

	public void setDeleteCard(String deleteCard) {
		this.deleteCard = deleteCard;
	}

	@Override
	public String toString() {
		return "DeleteCardData [deleteCard=" + deleteCard + "]";
	}
	
}
