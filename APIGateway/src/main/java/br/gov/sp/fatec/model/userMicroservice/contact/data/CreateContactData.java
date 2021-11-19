package br.gov.sp.fatec.model.userMicroservice.contact.data;

import br.gov.sp.fatec.model.userMicroservice.contact.dto.ContactDto;

public class CreateContactData {

	private ContactDto createContact;
	
	public CreateContactData() {}

	public CreateContactData(ContactDto createContact) {
		this.createContact = createContact;
	}

	public ContactDto getCreateContact() {
		return createContact;
	}

	public void setCreateContact(ContactDto createContact) {
		this.createContact = createContact;
	}

	@Override
	public String toString() {
		return "CreateContactData [createContact=" + createContact + "]";
	}
	
}
