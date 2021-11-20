package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.card.CreateCardDto;
import br.gov.sp.fatec.model.dto.card.UpdateCardDto;

@Entity
public class Card {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_card", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(length = 50)
	private String nickname;
	
	@Column(length = 100, name = "holder_name")
	private String holderName;
	
	@Column(length = 16)
	private String number;
	
	@Column(length = 5)
	private String cvv;
	
	@Column(length = 10, name = "expiration_date")
	private String expirationDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_card_customer")
	private Customer holder;
	
	public Card() {}

	public Card(String nickname, 
			String holderName, 
			String number, 
			String cvv, 
			String expirationDate) {
		this.nickname = nickname;
		this.holderName = holderName;
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}

	public Card(CreateCardDto dto) {
		this.nickname = dto.getNickname();
		this.holderName = dto.getHolderName();
		this.number = dto.getNumber();
		this.cvv = dto.getCvv();
		this.expirationDate = dto.getExpirationDate();
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
	
	public Customer getHolder() {
		return holder;
	}

	public void setHolder(Customer holder) {
		this.holder = holder;
	}
	
	public Card updateEntity(UpdateCardDto dto) {
		this.nickname = dto.getNickname() != "" ? dto.getNickname() : this.nickname;
		this.holderName = dto.getHolderName() != "" ? dto.getHolderName() : this.holderName;
		this.number = dto.getNumber();
		this.cvv = dto.getCvv();
		this.expirationDate = dto.getExpirationDate() != "" ? dto.getExpirationDate() : this.expirationDate;
		return this;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + 
				", nickname=" + nickname + 
				", holderName=" + holderName + 
				", number=" + number
				+ ", cvv=" + cvv + 
				", expirationDate=" + expirationDate + "]";
	}
	
}
