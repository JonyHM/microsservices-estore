package br.gov.sp.fatec.service;

import java.util.List;

import br.gov.sp.fatec.model.Contact;

public interface ContactService {

	public List<Contact> getAll();
	public Contact createContact(Contact contact, Long userId);
	public Contact getById(Long id);
	public Contact getByUserId(Long userId);
}
