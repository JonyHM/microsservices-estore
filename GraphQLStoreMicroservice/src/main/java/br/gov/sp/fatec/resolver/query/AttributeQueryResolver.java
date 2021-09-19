package br.gov.sp.fatec.resolver.query;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.sp.fatec.model.Attribute;
import br.gov.sp.fatec.service.attribute.AttributeService;
import graphql.kickstart.tools.GraphQLQueryResolver;

public class AttributeQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private AttributeService service;
	
	public Set<Attribute> getAttributes() {
		return service.getAttributes();
	}
	
	public Attribute getAttributeById(UUID id) {
		return service.getAttributeById(id);
	}
	
	public Set<Attribute> getAttributesByProductId(UUID productId) {
		return service.getAttributesByProductId(productId);
	}
}
