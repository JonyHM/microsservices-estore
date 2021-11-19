package br.gov.sp.fatec.model.userMicroservice.address.data;

public class DeleteAddressData {

	private String deleteAddress;

	public DeleteAddressData() {}
	
	public DeleteAddressData(String deleteAddress) {
		this.deleteAddress = deleteAddress;
	}

	public String getDeleteAddress() {
		return deleteAddress;
	}

	public void setDeleteAddress(String deleteAddress) {
		this.deleteAddress = deleteAddress;
	}

	@Override
	public String toString() {
		return "DeleteAddressData [deleteAddress=" + deleteAddress + "]";
	}
	
}
