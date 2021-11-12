package br.gov.sp.fatec.model.userMicroservice.contact.data;

import br.gov.sp.fatec.model.userMicroservice.contact.dto.ContactDto;

public class GetContactByIdData {

	private ContactDto getContactById;
	
	public GetContactByIdData() {}

	public GetContactByIdData(ContactDto getContactById) {
		this.getContactById = getContactById;
	}

	public ContactDto getGetContactById() {
		return getContactById;
	}

	public void setGetContactById(ContactDto getContactById) {
		this.getContactById = getContactById;
	}

	@Override
	public String toString() {
		return "GetContactByIdData [getContactById=" + getContactById + "]";
	}
	
}
