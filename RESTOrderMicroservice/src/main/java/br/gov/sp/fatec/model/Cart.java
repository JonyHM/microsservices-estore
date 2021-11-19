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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.dto.cart.CreateCartDto;
import br.gov.sp.fatec.model.enums.CartStatus;
import br.gov.sp.fatec.model.view.View;

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
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private UUID id;
		
	@Column(nullable = false, name = "id_user")
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private String userId;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "cart_product", 
        joinColumns = { @JoinColumn(name = "id_cart") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_order_product") }
    )
	@JsonView(value = View.Cart.class)
	private Set<OrderProduct> products;
	
	@Column(nullable = false, name = "created_date")
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private Timestamp createdDate;
	
	@Column(nullable = false, name = "updated_date")
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private Timestamp updatedDate;
	
	@Column(nullable = false)
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	@Enumerated(EnumType.STRING)
	private CartStatus status;
	
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cart_price")
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private Price totalValue;

	public Cart() {}
	
	public Cart(CreateCartDto dto) {
		this.createdDate = dto.getCreatedDate();
		this.updatedDate = dto.getUpdatedDate();
		this.userId = dto.getUserId();
		this.status = CartStatus.OPENED;
	}
	
	public Cart(
			Set<OrderProduct> products, 
			Timestamp createdDate, 
			Timestamp updatedDate, 
			String userId,
			Price totalValue) {
		this.products = products;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.totalValue = totalValue;
		this.status = CartStatus.OPENED;
		this.userId = userId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
	
	public Cart appendProduct(OrderProduct prod) {
		this.products.add(prod);
		return this;
	}
	
	public Cart appendProducts(Set<OrderProduct> products) {
		this.products.addAll(products);
		return this;
	}
	
	public Cart removeProduct(OrderProduct product) {
		this.products.remove(product);
		return this;
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

