package br.gov.sp.fatec.model.dto.cart;

import java.util.Set;

import br.gov.sp.fatec.model.dto.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.CreatePriceDto;

public class UpdateCartDto {

	private Set<CreateOrderProductDto> products;
	private CreatePriceDto totalValue;
	
	public UpdateCartDto() {}

	public UpdateCartDto(
			Set<CreateOrderProductDto> products,
			CreatePriceDto totalValue) {
		this.products = products;
		this.totalValue = totalValue;
	}

	public Set<CreateOrderProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<CreateOrderProductDto> products) {
		this.products = products;
	}

	public CreatePriceDto getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(CreatePriceDto totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "UpdateCartDto [products=" + products + 
				", totalValue=" + totalValue + "]";
	}
	
}
