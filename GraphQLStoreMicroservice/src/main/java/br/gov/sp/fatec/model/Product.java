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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.product.CreateProductDto;
import br.gov.sp.fatec.model.dto.product.UpdateProductDto;

@Entity
public class Product {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_product", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 100)
	private String description;
	
	@Column(nullable = false)
	private Long quantity;
	
	@Column(name = "unavailable_quantity", nullable = false)
	private Long unavailableQuantity;
	
	@OneToOne(
		cascade = CascadeType.REMOVE, 
		fetch = FetchType.EAGER
	)
	@JoinColumn(name = "id_product_price")
	private Price price;
	
	@OneToMany(
		cascade = CascadeType.REMOVE,
    	mappedBy = "product",
		orphanRemoval = true,
        fetch = FetchType.EAGER
    )
	private Set<Attribute> attributes;

	public Product() {}
	
	public Product(CreateProductDto dto) {
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.quantity = dto.getQuantity();
		this.unavailableQuantity = dto.getUnavailableQuantity();
	}
	
	public Product(
			String name, 
			String description,
			Long quantity, 
			Long unavailableQuantity) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.unavailableQuantity = unavailableQuantity;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Long getUnavailableQuantity() {
		return unavailableQuantity;
	}

	public void setUnavailableQuantity(Long unavailableQuantity) {
		this.unavailableQuantity = unavailableQuantity;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public Set<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}
	
	public void addUnavailableQuantity(Long unavailableQuantity) {
		this.unavailableQuantity = this.unavailableQuantity != null 
				? this.unavailableQuantity + unavailableQuantity 
				: unavailableQuantity;
		
		this.quantity = this.quantity != null 
				? this.quantity >= unavailableQuantity 
					? this.quantity - unavailableQuantity
					: 0
				: 0;
	}
	
	public void updatePaidCartProduct(Long quantity) {
		this.unavailableQuantity = this.unavailableQuantity != null 
				? this.unavailableQuantity >= quantity 
					? this.unavailableQuantity - quantity
					: 0
				: 0;
	}
	
	public void updateCanceledCartProduct(Long quantity) {
		
		this.unavailableQuantity = this.unavailableQuantity != null 
				? this.unavailableQuantity >= quantity 
					? this.unavailableQuantity - quantity
					: 0
				: 0;
		
		this.quantity = this.quantity != null 
				? this.quantity >= quantity 
					? this.quantity + quantity
					: 0
				: 0;
	}
	
	public Product updateEntity(UpdateProductDto dto) {
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.quantity = dto.getQuantity();
		this.unavailableQuantity = dto.getUnavailableQuantity();
		return this;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + 
				", name=" + name + 
				", description=" + description + 
				", quantity=" + quantity + 
				", unavailableQuantity=" + unavailableQuantity + "]";
	}
	
}
