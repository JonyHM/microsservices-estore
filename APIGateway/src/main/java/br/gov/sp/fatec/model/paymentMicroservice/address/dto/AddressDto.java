package br.gov.sp.fatec.model.paymentMicroservice.address.dto;

import java.util.UUID;

public class AddressDto {

	private UUID id;
	private String userAddressId;
	private String street;
	private String number;
	private String district;
	private String complement;
	private String city;
	private String state;
	private String country;
	
	public AddressDto() {}

	public AddressDto(
			UUID id, 
			String userAddressId, 
			String street, 
			String number, 
			String district, 
			String complement,
			String city, 
			String state, 
			String country) {
		this.id = id;
		this.userAddressId = userAddressId;
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(String userAddressId) {
		this.userAddressId = userAddressId;
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

	@Override
	public String toString() {
		return "AddressDto [id=" + id + 
				", userAddressId=" + userAddressId + 
				", street=" + street + 
				", number=" + number
				+ ", district=" + district + 
				", complement=" + complement + 
				", city=" + city + 
				", state=" + state
				+ ", country=" + country + "]";
	}
	
//	private Customer customer;
}
