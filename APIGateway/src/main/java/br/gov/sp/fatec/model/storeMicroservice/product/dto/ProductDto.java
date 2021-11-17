package br.gov.sp.fatec.model.storeMicroservice.product.dto;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.paymentMicroservice.order.dto.PriceDto;
import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.AttributeDto;

public class ProductDto {

	private UUID id;
	private String name;
	private String description;
	private Long quantityLong;
	private Long unavailableQuantity;
    private PriceDto price;
    private Set<AttributeDto> attributes;
    
    public ProductDto() {}

	public ProductDto(
			UUID id, 
			String name, 
			String description, 
			Long quantityLong, 
			Long unavailableQuantity,
			PriceDto price, 
			Set<AttributeDto> attributes) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantityLong = quantityLong;
		this.unavailableQuantity = unavailableQuantity;
		this.price = price;
		this.attributes = attributes;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getQuantityLong() {
		return quantityLong;
	}

	public void setQuantityLong(Long quantityLong) {
		this.quantityLong = quantityLong;
	}

	public Long getUnavailableQuantity() {
		return unavailableQuantity;
	}

	public void setUnavailableQuantity(Long unavailableQuantity) {
		this.unavailableQuantity = unavailableQuantity;
	}

	public PriceDto getPrice() {
		return price;
	}

	public void setPrice(PriceDto price) {
		this.price = price;
	}

	public Set<AttributeDto> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<AttributeDto> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "ProductDto [id=" + id + 
				", name=" + name + 
				", description=" + description + 
				", quantityLong=" + quantityLong + 
				", unavailableQuantity=" + unavailableQuantity + 
				", price=" + price + 
				", attributes=" + attributes + "]";
	}
    
}
