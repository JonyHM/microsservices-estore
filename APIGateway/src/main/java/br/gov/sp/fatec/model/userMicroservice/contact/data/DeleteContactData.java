package br.gov.sp.fatec.model.userMicroservice.contact.data;

public class DeleteContactData {

	private String deleteContact;
	
	public DeleteContactData() {}

	public DeleteContactData(String deleteContact) {
		this.deleteContact = deleteContact;
	}

	public String getDeleteContact() {
		return deleteContact;
	}

	public void setDeleteContact(String deleteContact) {
		this.deleteContact = deleteContact;
	}

	@Override
	public String toString() {
		return "DeleteContactData [deleteContact=" + deleteContact + "]";
	}
	
}
