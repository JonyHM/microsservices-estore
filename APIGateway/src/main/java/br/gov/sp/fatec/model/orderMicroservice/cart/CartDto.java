package br.gov.sp.fatec.model.orderMicroservice.cart;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.orderMicroservice.product.ProductDto;
import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;

public class CartDto {

	private UUID id;
	private UUID userId;
	private Set<ProductDto> products;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private String status;
	private PriceDto totalValue;
	
	public CartDto() {}

	public CartDto(
			UUID id, 
			UUID userId, 
			Set<ProductDto> products, 
			Timestamp createdDate, 
			Timestamp updatedDate,
			String status, 
			PriceDto totalValue) {
		this.id = id;
		this.userId = userId;
		this.products = products;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.status = status;
		this.totalValue = totalValue;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Set<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDto> products) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PriceDto getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(PriceDto totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		return "CartDto [id=" + id + 
				", userId=" + userId + 
				", products=" + products + 
				", createdDate=" + createdDate + 
				", updatedDate=" + updatedDate + 
				", status=" + status + 
				", totalValue=" + totalValue + "]";
	}
	
}
