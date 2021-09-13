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

import br.gov.sp.fatec.model.dto.CreateCardDto;

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
	private Long number;
	
	@Column(length = 5)
	private Long cvv;
	
	@Column(length = 10, name = "expiration_date")
	private String expirationDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_card_customer")
	private Customer holder;
	
	public Card() {}

	public Card(String nickname, 
			String holderName, 
			Long number, 
			Long cvv, 
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
	
	public Customer getHolder() {
		return holder;
	}

	public void setHolder(Customer holder) {
		this.holder = holder;
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
