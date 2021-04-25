package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	@Column(name = "number")
	private int number;
	
	@Column(length = 50)
	private String district;
	
	@Column(length = 200)
	private String complement;
	
	@Column(length = 40)
	private String city;
	
	@Column(length = 40)
	private String country;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address_user")
	private User user; 
}
