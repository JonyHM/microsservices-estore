package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateContactDto;

public interface ContactService {

	public List<Contact> getAll();
	public Contact getById(UUID id);
	public Contact getByUserId(UUID userId);
	public Contact createContact(CreateContactDto dto);
	public Contact updateContact(UpdateContactDto dto);
	public String deleteContact(UUID id);
}
