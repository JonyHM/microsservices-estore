package br.gov.sp.fatec.model.storeMicroservice.product.data;

public class DeleteProductData {

	private String deleteProduct;
	
	public DeleteProductData() {}

	public DeleteProductData(String deleteProduct) {
		this.deleteProduct = deleteProduct;
	}

	public String getDeleteProduct() {
		return deleteProduct;
	}

	public void setDeleteProduct(String deleteProduct) {
		this.deleteProduct = deleteProduct;
	}

	@Override
	public String toString() {
		return "DeleteProductData [deleteProduct=" + deleteProduct + "]";
	}
	
}
