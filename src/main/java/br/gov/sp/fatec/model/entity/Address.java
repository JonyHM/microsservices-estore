package br.gov.sp.fatec.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
public class Address {
	
	@Id
	@Column(name = "id_address")
	private Long id;
	
	@Column(length = 50)
	private String street;
	
	@Column(name = "id_address")
	private int number;
	
	@Column(length = 50)
	private String district;
	
	@Column(length = 200)
	private String complement;
	
	@Column(length = 40)
	private String city;
	
	@Column(length = 40)
	private String country;
}
