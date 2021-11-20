package br.gov.sp.fatec.model.paymentMicroservice.customer.data;

public class DeleteCustomerData {

	private String deleteCustomer;
	
	public DeleteCustomerData() {}

	public DeleteCustomerData(String deleteCustomer) {
		this.deleteCustomer = deleteCustomer;
	}

	public String getDeleteCustomer() {
		return deleteCustomer;
	}

	public void setDeleteCustomer(String deleteCustomer) {
		this.deleteCustomer = deleteCustomer;
	}

	@Override
	public String toString() {
		return "DeleteCustomerData [deleteCustomer=" + deleteCustomer + "]";
	}
	
}
