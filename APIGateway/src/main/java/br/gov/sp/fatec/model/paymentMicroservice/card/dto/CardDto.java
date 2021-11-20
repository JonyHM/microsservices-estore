package br.gov.sp.fatec.model.paymentMicroservice.card.dto;

import java.util.UUID;

public class CardDto {

	private UUID id;
	private String nickname;
	private String holderName;
	private String number;
	private String cvv;
	private String expirationDate;

	public CardDto() {}

	public CardDto(
			UUID id, 
			String nickname, 
			String holderName, 
			String number, 
			String cvv, 
			String expirationDate) {
		this.id = id;
		this.nickname = nickname;
		this.holderName = holderName;
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "CardDto [id=" + id + 
				", nickname=" + nickname + 
				", holderName=" + holderName + 
				", number=" + number + 
				", cvv=" + cvv + 
				", expirationDate=" + expirationDate + "]";
	}
	
}
