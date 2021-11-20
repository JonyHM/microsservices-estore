package br.gov.sp.fatec.model.dto.card;

import java.util.UUID;

public class CreateCardDto {

	private String nickname;
	private String holderName;
	private String number;
	private String cvv;
	private String expirationDate;
	private UUID holderId;
	
	public CreateCardDto() {}

	public CreateCardDto(String nickname, String holderName, String number, String cvv, String expirationDate,
			UUID holderId) {
		this.nickname = nickname;
		this.holderName = holderName;
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
		this.holderId = holderId;
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

	public UUID getHolderId() {
		return holderId;
	}

	public void setHolderId(UUID holderId) {
		this.holderId = holderId;
	}

	@Override
	public String toString() {
		return "CreateCardDto [nickname=" + nickname + ", holderName=" + holderName + ", number=" + number + ", cvv="
				+ cvv + ", expirationDate=" + expirationDate + ", holderId=" + holderId + "]";
	}
	
}
