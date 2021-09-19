package br.gov.sp.fatec.service.attribute;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.Attribute;
import br.gov.sp.fatec.model.dto.attribute.CreateAttributeDto;
import br.gov.sp.fatec.model.dto.attribute.UpdateAttributeDto;

public interface AttributeService {

	public Set<Attribute> getAttributes();
	public Attribute getAttributeById(UUID id);
	public Set<Attribute> getAttributesByProductId(UUID productId);
	public Attribute createAttribute(CreateAttributeDto dto);
	public Attribute updateAttribute(UpdateAttributeDto dto);
	public String deleteAttribute(UUID id);
}
