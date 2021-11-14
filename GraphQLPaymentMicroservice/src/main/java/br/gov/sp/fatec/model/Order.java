package br.gov.sp.fatec.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.order.CreateOrderDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.model.dto.order.UpdateOrderDto;
import br.gov.sp.fatec.model.enums.OrderStatus;

@Entity(name = "Order_Cart")
public class Order {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_order", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(unique = true, name = "id_cart")
	private UUID cartId;
	
	@Column(unique = true, name = "id_user")
	private String userId;
	
	@Column(length = 255)
	private String description;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_order_customer")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order_price")
	private Price price;
	
	public Order() {}

	public Order(
			UUID cartId,
			String userId,
			String description) {
		this.cartId = cartId;
		this.userId = userId;
		this.description = description;
		this.status = OrderStatus.OPENED;
	}
	
	public Order(CreateOrderDto dto) {
		this.cartId = dto.getCartId();
		this.description = dto.getDescription();
		this.userId = dto.getUserId();
		this.status = OrderStatus.OPENED;
	}
	
	public Order(StartOrderDto dto) {
		this.cartId = dto.getCartId();
		this.description = dto.getDescription();
		this.userId = dto.getUserId();
		this.status = OrderStatus.OPENED;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getCartId() {
		return cartId;
	}

	public void setCartId(UUID cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	 
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Order updateEntity(UpdateOrderDto dto) {
		this.description = dto.getDescription() != "" ? dto.getDescription() : this.description;
		return this;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + 
				", cartId=" + cartId +
				", status=" + status + 
				", user id=" + userId + 
				", description=" + description + "]";
	}
	
}
