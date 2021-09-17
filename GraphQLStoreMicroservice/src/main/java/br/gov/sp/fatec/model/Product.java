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
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 100)
	private String description;
	
	@Column()
	private Long quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_price", referencedColumnName = "id")
	private Price price;
}
