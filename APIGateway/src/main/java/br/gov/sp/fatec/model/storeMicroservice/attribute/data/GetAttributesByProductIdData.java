package br.gov.sp.fatec.model.storeMicroservice.attribute.data;

import java.util.Set;

import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.AttributeDto;

public class GetAttributesByProductIdData {

	private Set<AttributeDto> getAttributeByProductId;
	
	public GetAttributesByProductIdData() {}

	public GetAttributesByProductIdData(Set<AttributeDto> getAttributeByProductId) {
		this.getAttributeByProductId = getAttributeByProductId;
	}

	public Set<AttributeDto> getGetAttributeByProductId() {
		return getAttributeByProductId;
	}

	public void setGetAttributeByProductId(Set<AttributeDto> getAttributeByProductId) {
		this.getAttributeByProductId = getAttributeByProductId;
	}

	@Override
	public String toString() {
		return "GetAttributeByProductIdData [getAttributeByProductId=" + getAttributeByProductId + "]";
	}
	
}
