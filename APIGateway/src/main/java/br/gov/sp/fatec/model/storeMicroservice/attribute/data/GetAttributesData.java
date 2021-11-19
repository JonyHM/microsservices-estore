package br.gov.sp.fatec.model.storeMicroservice.attribute.data;

import java.util.Set;

import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.AttributeDto;

public class GetAttributesData {

	private Set<AttributeDto> getAttributes;
	
	public GetAttributesData() {}

	public GetAttributesData(Set<AttributeDto> getAttributes) {
		this.getAttributes = getAttributes;
	}

	public Set<AttributeDto> getGetAttributes() {
		return getAttributes;
	}

	public void setGetAttributes(Set<AttributeDto> getAttributes) {
		this.getAttributes = getAttributes;
	}

	@Override
	public String toString() {
		return "GetAttributesData [getAttributes=" + getAttributes + "]";
	}
	
}
