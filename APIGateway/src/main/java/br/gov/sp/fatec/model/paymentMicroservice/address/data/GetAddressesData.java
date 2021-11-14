package br.gov.sp.fatec.model.paymentMicroservice.address.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.address.dto.AddressDto;

public class GetAddressesData {

	private Set<AddressDto> getAddresses;
	
	public GetAddressesData() {}

	public GetAddressesData(Set<AddressDto> getAddresses) {
		this.getAddresses = getAddresses;
	}

	public Set<AddressDto> getGetAddresses() {
		return getAddresses;
	}

	public void setGetAddresses(Set<AddressDto> getAddresses) {
		this.getAddresses = getAddresses;
	}

	@Override
	public String toString() {
		return "GetAddressesData [getAddresses=" + getAddresses + "]";
	}
	
}
