package br.gov.sp.fatec.model.userMicroservice.address.data;

import br.gov.sp.fatec.model.userMicroservice.address.dto.AddressDto;

public class CreateAddressData {

	private AddressDto createAddress;
	
	public CreateAddressData() {}

	public CreateAddressData(AddressDto createAddress) {
		this.createAddress = createAddress;
	}

	public AddressDto getCreateAddress() {
		return createAddress;
	}

	public void setCreateAddress(AddressDto createAddress) {
		this.createAddress = createAddress;
	}

	@Override
	public String toString() {
		return "CreateAddressData [createAddress=" + createAddress + "]";
	}
	
}
