package br.gov.sp.fatec.model.paymentMicroservice.contact.data;

import java.util.Set;

import br.gov.sp.fatec.model.userMicroservice.contact.dto.ContactDto;

public class GetContactsByCustomerIdData {

	private Set<ContactDto> getContactsByCustomerId;
	
	public GetContactsByCustomerIdData() {}

	public GetContactsByCustomerIdData(Set<ContactDto> getContactsByCustomerId) {
		this.getContactsByCustomerId = getContactsByCustomerId;
	}

	public Set<ContactDto> getGetContactsByCustomerId() {
		return getContactsByCustomerId;
	}

	public void setGetContactsByCustomerId(Set<ContactDto> getContactsByCustomerId) {
		this.getContactsByCustomerId = getContactsByCustomerId;
	}

	@Override
	public String toString() {
		return "GetContactsByCustomerIdData [getContactsByCustomerId=" + getContactsByCustomerId + "]";
	}
	
}
