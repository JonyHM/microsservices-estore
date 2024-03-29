package br.gov.sp.fatec.model.dto.address;

import java.util.UUID;

import br.gov.sp.fatec.model.Address;

public class UpdateKafkaAddressDto {

	private UUID userId;
	private UUID userAddressId;
	private String street; 
	private String number;
	private String district;
	private String complement;
	private String city;
	private String state;
	private String country;
	
	public UpdateKafkaAddressDto() {}

	public UpdateKafkaAddressDto(
			UUID userId, 
			UUID userAddressId,
			String street, 
			String number, 
			String district, 
			String complement,
			String city, 
			String state, 
			String country) {
		this.userId = userId;
		this.userAddressId = userAddressId;
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public UpdateKafkaAddressDto(Address address) {
		this.userAddressId = address.getId();
		this.userId = address.getUser().getId();
		this.street = address.getStreet();
		this.number = address.getNumber();
		this.district = address.getDistrict();
		this.complement = address.getComplement();
		this.city = address.getCity();
		this.state = address.getState();
		this.country = address.getCountry();
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(UUID userAddressId) {
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
		return "UpdateKafkaAddressDto [userId=" + userId + 
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
