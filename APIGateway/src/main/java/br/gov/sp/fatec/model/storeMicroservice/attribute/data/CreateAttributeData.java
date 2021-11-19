package br.gov.sp.fatec.model.storeMicroservice.attribute.data;

import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.AttributeDto;

public class CreateAttributeData {

	private AttributeDto createAttribute;
	
	public CreateAttributeData() {}

	public CreateAttributeData(AttributeDto createAttribute) {
		this.createAttribute = createAttribute;
	}

	public AttributeDto getCreateAttribute() {
		return createAttribute;
	}

	public void setCreateAttribute(AttributeDto createAttribute) {
		this.createAttribute = createAttribute;
	}

	@Override
	public String toString() {
		return "CreateAttributeData [createAttribute=" + createAttribute + "]";
	}
	
}
