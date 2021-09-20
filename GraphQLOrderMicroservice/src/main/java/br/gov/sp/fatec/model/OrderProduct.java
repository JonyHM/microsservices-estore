package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.CreateOrderProductDto;

@Entity
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
	private UUID id;
	
	@Column(name = "id_product", nullable = false)
	private UUID productId;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 100)
	private String description;
	
	@Column(nullable = false)
	private Long quantity;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_product_price", referencedColumnName = "id")
	private Price price;
	
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

	@Override
	public String toString() {
		return "Product [id=" + id +
				", productId=" + productId + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + "]";
	}
	
}
