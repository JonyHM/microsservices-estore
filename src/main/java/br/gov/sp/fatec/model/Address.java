package br.gov.sp.fatec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@Column(name = "id_address")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address_user")
	private User user;
	
	public Address() {}

	public Address(String street, int number, String district, String complement, String city, String country,
			User user) {
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.country = country;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", number=" + number + ", district=" + district
				+ ", complement=" + complement + ", city=" + city + ", country=" + country + "]";
	}
}
