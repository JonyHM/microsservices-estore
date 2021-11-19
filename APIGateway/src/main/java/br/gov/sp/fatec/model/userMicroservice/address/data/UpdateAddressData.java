package br.gov.sp.fatec.model.userMicroservice.address.data;

import br.gov.sp.fatec.model.userMicroservice.address.dto.AddressDto;

public class UpdateAddressData {

	private AddressDto updateAddress;
	
	public UpdateAddressData() {}

	public UpdateAddressData(AddressDto updateAddress) {
		this.updateAddress = updateAddress;
	}

	public AddressDto getUpdateAddress() {
		return updateAddress;
	}

	public void setUpdateAddress(AddressDto updateAddress) {
		this.updateAddress = updateAddress;
	}

	@Override
	public String toString() {
		return "UpdateAddressData [updateAddress=" + updateAddress + "]";
	}
	
}
