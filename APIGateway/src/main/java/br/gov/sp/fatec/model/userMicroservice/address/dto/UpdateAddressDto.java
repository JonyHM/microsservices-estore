package br.gov.sp.fatec.model.userMicroservice.address.dto;

import java.util.UUID;

public class UpdateAddressDto {

	private UUID addressId;
	private String street;
	private String number;
	private String district;
	private String complement;
	private String city;
	private String state;
	private String country;
	
	public UpdateAddressDto() {}

	public UpdateAddressDto(
			UUID addressId, 
			String street, 
			String number, 
			String district, 
			String complement,
			String city, 
			String state, 
			String country) {
		this.addressId = addressId;
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public UUID getAddressId() {
		return addressId;
	}

	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
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
		return "UpdateAddressDto [addressId=" + addressId + 
				", street=" + street + 
				", number=" + number + 
				", district=" + district + 
				", complement=" + complement + 
				", city=" + city + 
				", state=" + state + 
				", country=" + country + "]";
	}
	
}
