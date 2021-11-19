package br.gov.sp.fatec.model.userMicroservice.contact.data;

import java.util.Set;

import br.gov.sp.fatec.model.userMicroservice.contact.dto.ContactDto;

public class GetContactsData {

	private Set<ContactDto> contacts;
	
	public GetContactsData() {}

	public GetContactsData(Set<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public Set<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(Set<ContactDto> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "GetContactsData [contacts=" + contacts + "]";
	}
	
}
