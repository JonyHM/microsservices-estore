package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.contact.CreatekafkaContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateKafkaContactDto;

public interface ContactService {

	public List<Contact> getAll();
	public Contact getById(UUID id);
	public List<Contact> getByCustomerId(UUID customerId);
	public Contact createContact(CreateContactDto dto);
	public Contact createKafkaContact(CreatekafkaContactDto dto);
	public Contact updateContact(UpdateContactDto dto);
	public Contact updateKafkaContact(UpdateKafkaContactDto dto);
	public String deleteContact(UUID id);
	public String deleteByUserContactId(UUID id);
}
