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
import br.gov.sp.fatec.model.dto.address.CreateKafkaAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateAddressDto;
import br.gov.sp.fatec.model.dto.address.UpdateKafkaAddressDto;

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
	
	@Type(type = "uuid-char")
	@Column(name = "id_user_address")
	private UUID userAddressId;
	
	@Column(length = 50)
	private String street;
	
	@Column(length = 5)
	private String number;
	
	@Column(length = 50)
	private String district;
	
	@Column(length = 200)
	private String complement;
	
	@Column(length = 40)
	private String city;
	
	@Column(length = 2)
	private String state;
	
	@Column(length = 40)
	private String country;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_address_customer")
	private Customer customer;
	
	public Address() {}

	public Address(
			UUID userAddressId,
			String street, 
			String number, 
			String district, 
			String complement, 
			String city, 
			String state,
			String country) {
		this.userAddressId = userAddressId;
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public Address(CreateAddressDto dto) {
		this.street = dto.getStreet();
		this.number = dto.getNumber();
		this.district = dto.getDistrict();
		this.complement = dto.getComplement();
		this.city = dto.getCity();
		this.state = dto.getState();
		this.country = dto.getCountry();
	}
	
	public Address(CreateKafkaAddressDto dto) {
		this.userAddressId = dto.getUserAddressId();
		this.street = dto.getStreet();
		this.number = dto.getNumber();
		this.district = dto.getDistrict();
		this.complement = dto.getComplement();
		this.city = dto.getCity();
		this.state = dto.getState();
		this.country = dto.getCountry();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(UUID userId) {
		this.userAddressId = userId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Address updateEntity(UpdateAddressDto dto) {
		this.street = dto.getStreet() != "" ? dto.getStreet() : this.street;
		this.number = dto.getNumber();
		this.district = dto.getDistrict() != "" ? dto.getDistrict() : this.district;
		this.complement = dto.getComplement() != "" ? dto.getComplement() : this.complement;
		this.city = dto.getCity() != "" ? dto.getCity() : this.city;
		this.state = dto.getState() != "" ? dto.getState() : this.state;
		this.country = dto.getCountry() != "" ? dto.getCountry() : this.country;
		return this;
	}
	
	public Address updateEntity(UpdateKafkaAddressDto dto) {
		this.userAddressId = dto.getUserAddressId();
		this.street = dto.getStreet() != "" ? dto.getStreet() : this.street;
		this.number = dto.getNumber();
		this.district = dto.getDistrict() != "" ? dto.getDistrict() : this.district;
		this.complement = dto.getComplement() != "" ? dto.getComplement() : this.complement;
		this.city = dto.getCity() != "" ? dto.getCity() : this.city;
		this.state = dto.getState() != "" ? dto.getState() : this.state;
		this.country = dto.getCountry() != "" ? dto.getCountry() : this.country;
		return this;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + 
				", userAddressId=" + userAddressId + 
				", street=" + street + 
				", number=" + number + 
				", district=" + district + 
				", complement=" + complement + 
				", city=" + city +
				", state=" + state + 
				", country=" + country + "]";
	}
}
