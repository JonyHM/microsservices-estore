package br.gov.sp.fatec.model.dto.address;

import java.util.UUID;

public class UpdateAddressDto {

	private UUID addressId;
	private String street; 
	private Long number;
	private String district;
	private String complement;
	private String city;
	private String country;
	private UUID userId;
	
	public UpdateAddressDto() {}

	public UpdateAddressDto(
			UUID addressId, 
			String street, 
			Long number, 
			String district, 
			String complement, 
			String city,
			String country, 
			UUID userId) {
		this.addressId = addressId;
		this.street = street;
		this.number = number;
		this.district = district;
		this.complement = complement;
		this.city = city;
		this.country = country;
		this.userId = userId;
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

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UpdateAddressDto [addressId=" + addressId + 
				", street=" + street + 
				", number=" + number + 
				", district=" + district + 
				", complement=" + complement + 
				", city=" + city + 
				", country=" + country + 
				", userId=" + userId + "]";
	}
	
}
