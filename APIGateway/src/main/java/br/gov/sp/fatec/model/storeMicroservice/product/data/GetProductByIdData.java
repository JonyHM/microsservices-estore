package br.gov.sp.fatec.model.storeMicroservice.product.data;

import br.gov.sp.fatec.model.storeMicroservice.product.dto.ProductDto;

public class GetProductByIdData {

	private ProductDto getProductById;
	
	public GetProductByIdData() {}

	public GetProductByIdData(ProductDto getProductById) {
		this.getProductById = getProductById;
	}

	public ProductDto getGetProductById() {
		return getProductById;
	}

	public void setGetProductById(ProductDto getProductById) {
		this.getProductById = getProductById;
	}

	@Override
	public String toString() {
		return "GetProductByIdData [getProductById=" + getProductById + "]";
	}
	
}
