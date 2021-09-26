package br.gov.sp.fatec.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.orderProduct.UpdateOrderProductDto;
import br.gov.sp.fatec.model.view.View;

@Entity(name = "order_product")
public class OrderProduct {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_order_product", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private UUID id;
	
	@Column(name = "id_product", nullable = false)
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private UUID productId;
	
	@Column(length = 50, nullable = false)
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private String name;
	
	@Column(length = 100)
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private String description;
	
	@Column(nullable = false)
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private Long quantity;
	
	@OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_product_price")
	@JsonView(value = {
		View.Cart.class,
		View.Product.class
	})
	private Price price;
	
	@ManyToMany(mappedBy = "products")
	@JsonView(value = View.Product.class)
	private Set<Cart> carts;
	
	public OrderProduct() {}
	
	public OrderProduct(CreateOrderProductDto dto) {
		this.productId = dto.getProductId();
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.quantity = dto.getQuantity();
	}

	public OrderProduct(
			UUID productId,
			String name, 
			String description, 
			Long quantity, 
			Price price) {
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	public Set<Cart> getCarts() {
		return carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

	public OrderProduct updateEntity(UpdateOrderProductDto dto) {
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.quantity = dto.getQuantity();
		return this;
	}

	@Override
	public String toString() {
		return "Product [id=" + id +
				", productId=" + productId + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + "]";
	}
	
}
