package br.gov.sp.fatec.model.userMicroservice.address.data;

import br.gov.sp.fatec.model.userMicroservice.address.dto.AddressDto;

public class GetAddressByIdData {

	private AddressDto getAddressById;
	
	public GetAddressByIdData() {}

	public GetAddressByIdData(AddressDto getAddressById) {
		this.getAddressById = getAddressById;
	}

	public AddressDto getGetAddressById() {
		return getAddressById;
	}

	public void setGetAddressById(AddressDto getAddressById) {
		this.getAddressById = getAddressById;
	}

	@Override
	public String toString() {
		return "GetAddressByIdData [getAddressById=" + getAddressById + "]";
	}
	
}
