package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.price.CreateItemPriceDto;
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
	
	@Column(length = 3)
	private String currency;
	
	@Column()
	private Double amount;
	
	@OneToOne(
		mappedBy = "price", 
		fetch = FetchType.EAGER
	)
	private Product product;

	public Price() {}
	
	public Price(CreateItemPriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
	}
	
	public Price(CreatePriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
	}
	
	public Price(String currency, Double amount) {
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Price updateEntity(UpdatePriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
		return this;
	}
	
	public Price updateEntity(CreateItemPriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
		return this;
	}
	
	public Price updateEntity(CreatePriceDto dto) {
		this.currency = dto.getCurrency();
		this.amount = dto.getAmount();
		return this;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", currency=" + currency + ", amount=" + amount + "]";
	}
	
}
