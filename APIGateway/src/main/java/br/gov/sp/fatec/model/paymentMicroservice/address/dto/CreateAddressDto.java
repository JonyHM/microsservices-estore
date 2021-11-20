package br.gov.sp.fatec.model.paymentMicroservice.address.dto;

import java.util.UUID;

public class CreateAddressDto {

	private String street;
	private String number;
	private String district;
	private String complement;
	private String city;
	private String state;
	private String country;
	private UUID customerId;
	
	public CreateAddressDto() {}

	public CreateAddressDto(
			String street, 
			String number, 
			String district, 
			String complement, 
			String city, 
			String state,
			String country, 
			UUID customerId) {
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
		this.customerId = customerId;
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

	public UUID getCustomerId() {
		return customerId;
	}

	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "CreateAddressDto [street=" + street + 
				", number=" + number + 
				", district=" + district + 
				", complement=" + complement + 
				", city=" + city + 
				", state=" + state + 
				", country=" + country + 
				", customerId=" + customerId + "]";
	}
	
}
