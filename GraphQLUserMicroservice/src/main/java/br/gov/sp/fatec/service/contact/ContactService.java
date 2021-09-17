package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.dto.CreateContactDto;

public interface ContactService {

	public List<Contact> getAll();
	public Contact createContact(CreateContactDto contactDto);
	public Contact getById(UUID id);
	public Contact getByUserId(UUID userId);
}
