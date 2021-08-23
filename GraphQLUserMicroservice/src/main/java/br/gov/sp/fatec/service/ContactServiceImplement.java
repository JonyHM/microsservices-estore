package br.gov.sp.fatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.repository.ContactRepository;
import br.gov.sp.fatec.repository.UserRepository;

@Service
public class ContactServiceImplement implements ContactService {

	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Contact> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Contact createContact(Contact contact, Long userId) {
		Optional<User> user = userRepo.findById(userId);
		
		if(!user.isPresent()) {
			throw new RuntimeException("Usuário não encontrado!");
		}
		
		User foundUser = user.get();
		foundUser.getContacts().add(contact);
		userRepo.save(foundUser);
		
		contact.setUser(foundUser);
		return repository.save(contact);
	}
	
	@Override
	public Contact getById(Long id) {
		Optional<Contact> contact = repository.findById(id);
		
		if(!contact.isPresent()) {
			throw new RuntimeException("Contato não encontrado!");
		}
		return contact.get();
	}
	

	@Override
	public Contact getByUserId(Long userId) {
		Optional<Contact> contact = repository.findByUserId(userId);
		
		if(!contact.isPresent()) {
			throw new RuntimeException("Contato não encontrado!");
		}
		return contact.get();
	}
}
