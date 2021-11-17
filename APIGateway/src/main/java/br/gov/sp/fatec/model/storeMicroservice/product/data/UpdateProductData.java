package br.gov.sp.fatec.model.storeMicroservice.product.data;

import br.gov.sp.fatec.model.storeMicroservice.product.dto.ProductDto;

public class UpdateProductData {

	private ProductDto updateProduct;
	
	public UpdateProductData() {}

	public UpdateProductData(ProductDto updateProduct) {
		this.updateProduct = updateProduct;
	}

	public ProductDto getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(ProductDto updateProduct) {
		this.updateProduct = updateProduct;
	}

	@Override
	public String toString() {
		return "UpdateProductData [updateProduct=" + updateProduct + "]";
	}
	
}
