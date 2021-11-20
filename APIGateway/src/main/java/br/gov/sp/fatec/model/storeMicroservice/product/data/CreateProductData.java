package br.gov.sp.fatec.model.storeMicroservice.product.data;

import br.gov.sp.fatec.model.storeMicroservice.product.dto.ProductDto;

public class CreateProductData {

	private ProductDto createProduct;
	
	public CreateProductData() {}

	public CreateProductData(ProductDto createProduct) {
		this.createProduct = createProduct;
	}

	public ProductDto getCreateProduct() {
		return createProduct;
	}

	public void setCreateProduct(ProductDto createProduct) {
		this.createProduct = createProduct;
	}

	@Override
	public String toString() {
		return "CreateProductData [createProduct=" + createProduct + "]";
	}
	
}
