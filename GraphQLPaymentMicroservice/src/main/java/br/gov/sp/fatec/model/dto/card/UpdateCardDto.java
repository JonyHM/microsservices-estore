package br.gov.sp.fatec.model.dto.card;

import java.util.UUID;

public class UpdateCardDto {

	private UUID cardId;
	private String nickname;
	private String holderName;
	private Long number;
	private Long cvv;
	private String expirationDate;
	
	public UpdateCardDto() {}

	public UpdateCardDto(
			UUID cardId, 
			String nickname, 
			String holderName, 
			Long number, 
			Long cvv, 
			String expirationDate) {
		this.cardId = cardId;
		this.nickname = nickname;
		this.holderName = holderName;
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}

	public UUID getCardId() {
		return cardId;
	}

	public void setCardId(UUID cardId) {
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

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getCvv() {
		return cvv;
	}

	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "UpdateCardDto [cardId=" + cardId + 
				", nickname=" + nickname + 
				", holderName=" + holderName + 
				", number=" + number + 
				", cvv=" + cvv + 
				", expirationDate=" + expirationDate + "]";
	}
	
}
