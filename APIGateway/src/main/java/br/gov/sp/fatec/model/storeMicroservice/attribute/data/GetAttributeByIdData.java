package br.gov.sp.fatec.model.storeMicroservice.attribute.data;

import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.AttributeDto;

public class GetAttributeByIdData {

	private AttributeDto getAttributeById;
	
	public GetAttributeByIdData() {}

	public GetAttributeByIdData(AttributeDto getAttributeById) {
		this.getAttributeById = getAttributeById;
	}

	public AttributeDto getGetAttributeById() {
		return getAttributeById;
	}

	public void setGetAttributeById(AttributeDto getAttributeById) {
		this.getAttributeById = getAttributeById;
	}

	@Override
	public String toString() {
		return "GetAttributeByIdData [getAttributeById=" + getAttributeById + "]";
	}
	
}
