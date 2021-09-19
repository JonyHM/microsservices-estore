package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateContactDto;
import br.gov.sp.fatec.service.contact.ContactService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class ContactMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private ContactService service;

	public Contact createContact(CreateContactDto contact) throws NotFoundException {
		return service.createContact(contact);
	}
	
	public Contact updateContact(UpdateContactDto contact) {
		return service.updateContact(contact);
	}
	
	public String deleteContact(UUID contactId) {
		return service.deleteContact(contactId);
	}
}
