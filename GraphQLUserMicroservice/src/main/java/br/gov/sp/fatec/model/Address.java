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

import br.gov.sp.fatec.model.dto.address.CreateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		name = "UUID",
		strategy = "org.hibernate.id.UUIDGenerator"
	)
	@Column(name = "id_address", updatable = false, nullable = false)
	@ColumnDefault("random_uuid()")
	@Type(type = "uuid-char")
	private UUID id;
	
	@Column(length = 50)
	private String street;
	
	@Column(name = "number")
	private Long number;
	
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
	
	public Address(CreateAddressDto dto) {
		this.street = dto.getStreet();
		this.number = dto.getNumber();
		this.district = dto.getDistrict();
		this.complement = dto.getComplement();
		this.city = dto.getCity();
		this.country = dto.getCountry();
	}

	public Address(
			String street, 
			Long number, 
			String district, 
			String complement, 
			String city, 
			String country,
			User user) {
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.country = country;
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
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
	
	public Address updateEntity(UpdateAddressDto dto) {
		this.street = dto.getStreet() != "" ? dto.getStreet() : this.street;
		this.number = dto.getNumber();
		this.district = dto.getDistrict() != "" ? dto.getDistrict() : this.district;
		this.complement = dto.getComplement() != "" ? dto.getComplement() : this.complement;
		this.city = dto.getCity() != "" ? dto.getCity() : this.city;
		this.country = dto.getCountry() != "" ? dto.getCountry() : this.country;
		return this;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + 
				", street=" + street + 
				", number=" + number + 
				", district=" + district + 
				", complement=" + complement + 
				", city=" + city + 
				", country=" + country + "]";
	}
}
