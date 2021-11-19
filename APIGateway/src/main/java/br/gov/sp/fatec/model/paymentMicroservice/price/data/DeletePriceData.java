package br.gov.sp.fatec.model.paymentMicroservice.price.data;

public class DeletePriceData {

	private String deletePrice;
	
	public DeletePriceData() {}

	public DeletePriceData(String deletePrice) {
		this.deletePrice = deletePrice;
	}

	public String getDeletePrice() {
		return deletePrice;
	}

	public void setDeletePrice(String deletePrice) {
		this.deletePrice = deletePrice;
	}

	@Override
	public String toString() {
		return "DeletePriceData [deletePrice=" + deletePrice + "]";
	}
	
}
