package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.price.CreateOrderPriceDto;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;
import br.gov.sp.fatec.model.dto.price.UpdatePriceDto;


@Entity
public class Price {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_price", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(length = 3, nullable = false)
	private String currency;
	
	@Column(nullable = false)
	private Double amount;
	
	public Price() {
		this.currency = "";
		this.amount = new Double(0);
	}
	
	public Price(CreatePriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
	}
	
	public Price(CreateOrderPriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
	}
	 
	public Price(
			String currency, 
			Double amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Boolean isEqualTo(Price price) {
		return Double.compare(price.getAmount(), this.amount) == 0 && 
				price.getCurrency().equals(this.currency);
	}
	
	public void addAmount(Double amount) {
		this.amount = Double.sum(amount, this.amount);
	}
	
	public Price updateEntity(CreatePriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
		return this;
	}
	
	public Price updateEntity(UpdatePriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
		return this;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + 
				", currency=" + currency + 
				", amount=" + amount + "]";
	}
	
}

