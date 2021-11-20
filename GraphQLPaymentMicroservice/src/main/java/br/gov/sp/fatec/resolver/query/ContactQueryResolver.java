package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.service.contact.ContactService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javassist.NotFoundException;

@Component
public class ContactQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private ContactService service;
	
	public List<Contact> getContacts() {
		return service.getAll();
	}
	
	public Contact getContactById(UUID id) throws NotFoundException {
		return service.getById(id);
	}

	public List<Contact> getContactsByCustomerId(UUID customerId) throws NotFoundException {
		return service.getByCustomerId(customerId);
	}
}
