package br.gov.sp.fatec.model.storeMicroservice.product.data;

import java.util.Set;

import br.gov.sp.fatec.model.storeMicroservice.product.dto.ProductDto;

public class GetProductsData {

	private Set<ProductDto> getProducts;
	
	public GetProductsData() {}

	public GetProductsData(Set<ProductDto> getProducts) {
		this.getProducts = getProducts;
	}

	public Set<ProductDto> getGetProducts() {
		return getProducts;
	}

	public void setGetProducts(Set<ProductDto> getProducts) {
		this.getProducts = getProducts;
	}

	@Override
	public String toString() {
		return "GetProductsData [getProducts=" + getProducts + "]";
	}
	
}
