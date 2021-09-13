package br.gov.sp.fatec.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.dto.CreateContactDto;
import br.gov.sp.fatec.service.contact.ContactService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class ContactMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private ContactService service;

	public Contact createContact(CreateContactDto dto) throws NotFoundException {
		return service.createContact(dto);
	}
}
