package br.gov.sp.fatec.model.paymentMicroservice.address.data;

import java.util.Set;

import br.gov.sp.fatec.model.paymentMicroservice.address.dto.AddressDto;

public class GetAddressesByCustomerIdData {

	private Set<AddressDto> getAddressesByCustomerId;
	
	public GetAddressesByCustomerIdData() {}

	public GetAddressesByCustomerIdData(Set<AddressDto> getAddressesByCustomerId) {
		this.getAddressesByCustomerId = getAddressesByCustomerId;
	}

	public Set<AddressDto> getGetAddressesByCustomerId() {
		return getAddressesByCustomerId;
	}

	public void setGetAddressesByCustomerId(Set<AddressDto> getAddressesByCustomerId) {
		this.getAddressesByCustomerId = getAddressesByCustomerId;
	}

	@Override
	public String toString() {
		return "GetAddressesByCustomerIdData [getAddressesByCustomerId=" + getAddressesByCustomerId + "]";
	}
	
}
