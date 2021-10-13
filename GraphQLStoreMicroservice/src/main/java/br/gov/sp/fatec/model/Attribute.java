package br.gov.sp.fatec.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import br.gov.sp.fatec.model.dto.attribute.CreateAttributeDto;
import br.gov.sp.fatec.model.dto.attribute.UpdateAttributeDto;

@Entity
public class Attribute {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_attribute", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String value;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_attribute_product")
	private Product product;

	public Attribute() {}
	
	public Attribute(CreateAttributeDto dto) {
		this.name = dto.getName();
		this.value = dto.getValue();
	}
	
	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Attribute updateEntity(UpdateAttributeDto dto) {
		this.name = dto.getName();
		this.value = dto.getValue();
		return this;
	}

	@Override
	public String toString() {
		return "Attribute [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
}
