package br.gov.sp.fatec.model.userMicroservice.contact.data;

import br.gov.sp.fatec.model.userMicroservice.contact.dto.ContactDto;

public class UpdateContactData {

	private ContactDto updateContact;

	public UpdateContactData() {}

	public UpdateContactData(ContactDto updateContact) {
		this.updateContact = updateContact;
	}

	public ContactDto getUpdateContact() {
		return updateContact;
	}

	public void setUpdateContact(ContactDto updateContact) {
		this.updateContact = updateContact;
	}

	@Override
	public String toString() {
		return "UpdateContactData [updateContact=" + updateContact + "]";
	}
	
}
