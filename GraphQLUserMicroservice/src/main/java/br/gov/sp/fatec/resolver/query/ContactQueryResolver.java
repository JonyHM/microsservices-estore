package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.service.contact.ContactService;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ContactQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private ContactService service;
	
	public List<Contact> getContacts() {
		return service.getAll();
	}
	
	public Contact getContactById(UUID id) {
		return service.getById(id);
	}
	
	public Set<Contact> getContactsByUserId(UUID userId) {
		return service.getByUserId(userId);
	}
}
