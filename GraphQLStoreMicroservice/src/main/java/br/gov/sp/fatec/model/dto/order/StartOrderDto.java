package br.gov.sp.fatec.model.dto.order;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.dto.product.ProductDto;

public class StartOrderDto {

	private UUID userId;
	private Set<ProductDto> products;
	private String description;
	
	public StartOrderDto() {}

	public StartOrderDto(
			UUID userId, 
			String description, 
			Set<ProductDto> products) {
		this.userId = userId;
		this.description = description;
		this.products = products;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "CreateCustomerDto [userId=" + userId + 
				", description=" + description + 
				", products=" + products + "]";
	}
	
}
