package br.gov.sp.fatec.model.storeMicroservice.attribute.data;

import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.AttributeDto;

public class UpdateAttributeData {

	private AttributeDto updateAttribute;
	
	public UpdateAttributeData() {}

	public UpdateAttributeData(AttributeDto updateAttribute) {
		this.updateAttribute = updateAttribute;
	}

	public AttributeDto getUpdateAttribute() {
		return updateAttribute;
	}

	public void setUpdateAttribute(AttributeDto updateAttribute) {
		this.updateAttribute = updateAttribute;
	}

	@Override
	public String toString() {
		return "UpdateAttributeData [updateAttribute=" + updateAttribute + "]";
	}
	
}
