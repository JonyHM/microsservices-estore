package br.gov.sp.fatec.model;

import java.rmi.server.UID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card {

	@Id
	@Column(name = "id_card")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UID id;
	
	@Column(length = 50)
	private String nickname;
	
	@Column(length = 50, name = "holder_name")
	private String holderName;
	
	@Column(length = 50)
	private Long number;
	
	@Column(length = 50)
	private Long cvv;
	
	@Column(length = 50, name = "expiration_date")
	private String expirationDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_card_customer")
	private Customer holder;
	
	public Card() {}

	public Card(UID id, 
			String nickname, 
			String holderName, 
			Long number, 
			Long cvv, 
			String expirationDate) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.holderName = holderName;
		this.number = number;
		this.cvv = cvv;
		this.expirationDate = expirationDate;
	}

	public UID getId() {
		return id;
	}

	public void setId(UID id) {
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
