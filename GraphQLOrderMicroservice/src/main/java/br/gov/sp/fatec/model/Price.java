package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.CreatePriceDto;

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
	
	@OneToOne(mappedBy = "price")
	private OrderProduct product;
	
	@OneToOne(mappedBy = "price")
	private Cart cart;
	
	@OneToOne(mappedBy = "price")
	private Discount discount;

	public Price() {}
	
	public Price(CreatePriceDto dto) {
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

	public OrderProduct getProduct() {
		return product;
	}

	public void setProduct(OrderProduct product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
	public Boolean isEqualTo(Price price) {
		return Double.compare(price.getAmount(), this.amount) == 0 && 
				price.getCurrency().equals(this.currency);
	}
	
	public void addAmount(Double amount) {
		this.amount = Double.sum(amount, this.amount);
	}

	@Override
	public String toString() {
		return "Price [id=" + id + 
				", currency=" + currency + 
				", amount=" + amount + "]";
	}
	
}
