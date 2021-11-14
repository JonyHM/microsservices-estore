package br.gov.sp.fatec.model.paymentMicroservice.card.dto;

import java.util.UUID;

public class UpdateCardDto {

	private String nickname;
	private String holderName;
	private String number;
	private String cvv;
	private String expirationDate;
	private UUID cardId;
	
	public UpdateCardDto() {}

	public UpdateCardDto(
			String nickname, 
			String holderName, 
			String number, 
			String cvv, 
			String expirationDate,
			UUID cardId) {
		this.nickname = nickname;
		this.holderName = holderName;
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		this.cardId = cardId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public UUID getCardId() {
		return cardId;
	}

	public void setCardId(UUID cardId) {
		this.cardId = cardId;
	}

	@Override
	public String toString() {
		return "UpdateCardDto [nickname=" + nickname + 
				", holderName=" + holderName + 
				", number=" + number + 
				", cvv=" + cvv + 
				", expirationDate=" + expirationDate + 
				", cardId=" + cardId + "]";
	}
	
}
