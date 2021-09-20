package br.gov.sp.fatec.model;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Cart {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_cart", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
		
	@Column(unique = true, nullable = false)
	private UUID userId;
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
    	mappedBy = "product",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<OrderProduct> products;
	
	@Column(nullable = false)
	private Timestamp createdDate;
	
	@Column(nullable = false)
	private Timestamp updatedDate;
	
	@Enumerated(EnumType.STRING)
	private CartStatus status;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_cart_price", referencedColumnName = "id")
	private Price totalValue;

	public Cart() {}
	
	public Cart(
			Set<OrderProduct> products, 
			Timestamp createdDate, 
			Timestamp updatedDate, 
			Price totalValue) {
		this.products = products;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.totalValue = totalValue;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Set<OrderProduct> getProducts() {
		return products;
	}

	public void setProducts(Set<OrderProduct> products) {
		this.products = products;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public CartStatus getStatus() {
		return status;
	}

	public void setStatus(CartStatus status) {
		this.status = status;
	}

	public Price getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Price totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id +
				", userId=" + userId + 
				", createdDate=" + createdDate + 
				", updatedDate=" + updatedDate +
				", status=" + status + "]";
	}
	
}

