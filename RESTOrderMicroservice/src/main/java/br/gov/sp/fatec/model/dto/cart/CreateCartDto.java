package br.gov.sp.fatec.model.dto.cart;

import java.sql.Timestamp;
import java.util.Set;

import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.price.CreatePriceDto;

public class CreateCartDto {

	private Set<CreateOrderProductDto> products;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private CreatePriceDto totalValue;
	private String userId;
	
	public CreateCartDto() {}

	public CreateCartDto(
			Set<CreateOrderProductDto> products, 
			Timestamp createdDate, 
			Timestamp updatedDate,
			CreatePriceDto totalValue,
			String userId) {
		this.products = products;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.totalValue = totalValue;
		this.userId = userId;
	}

	public Set<CreateOrderProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<CreateOrderProductDto> products) {
		this.products = products;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	public CreatePriceDto getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(CreatePriceDto totalValue) {
		this.totalValue = totalValue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CreateCartDto [products=" + products + 
				", createdDate=" + createdDate + 
				", updatedDate=" + updatedDate + 
				", totalValue=" + totalValue + 
				", userId=" + userId + "]";
	}
		
}
