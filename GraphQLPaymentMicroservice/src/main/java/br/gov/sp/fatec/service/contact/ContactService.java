package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.dto.CreateContactDto;
import javassist.NotFoundException;

public interface ContactService {

	public List<Contact> getAll();
	public Contact createContact(CreateContactDto dto) throws NotFoundException;
	public Contact getById(UUID id) throws NotFoundException;
	public List<Contact> getByCustomerId(UUID customerId) throws NotFoundException;
}
