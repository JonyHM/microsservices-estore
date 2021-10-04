package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Attribute;
import br.gov.sp.fatec.model.dto.attribute.CreateAttributeDto;
import br.gov.sp.fatec.model.dto.attribute.UpdateAttributeDto;
import br.gov.sp.fatec.service.attribute.AttributeService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class AttributeMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private AttributeService service;
	
	public Attribute createAttribute(CreateAttributeDto attribute) {
		return service.createAttribute(attribute);
	}
	
	public Attribute updateAttribute(UpdateAttributeDto attribute) {
		return service.updateAttribute(attribute);
	}
	
	public String deleteAttribute(UUID attributeId) {
		return service.deleteAttribute(attributeId);
	}
}
