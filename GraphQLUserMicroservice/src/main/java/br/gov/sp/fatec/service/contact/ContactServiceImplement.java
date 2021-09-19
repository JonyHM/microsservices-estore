package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateContactDto;
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
	public Contact createContact(CreateContactDto dto) {
		Optional<User> user = userRepo.findById(dto.getUserId());
		Contact contact = new Contact(dto);
		
		if(!user.isPresent()) {
			throw new NotFoundException(String.format("User with id %s does not exist!", dto.getUserId()));
		}
		
		User foundUser = user.get();
		foundUser.getContacts().add(contact);
		userRepo.save(foundUser);
		
		contact.setUser(foundUser);
		return repository.save(contact);
	}
	
	@Override
	public Contact getById(UUID id) {
		Optional<Contact> contact = repository.findById(id);
		
		if(!contact.isPresent()) {
			throw new NotFoundException(String.format("Could not find Contact with id %s", id));
		}
		return contact.get();
	}
	

	@Override
	public Contact getByUserId(UUID userId) {
		Optional<Contact> contact = repository.findByUserId(userId);
		
		if(!contact.isPresent()) {
			throw new NotFoundException(String.format("Could not find Contact for user with id %s", userId));
		}
		return contact.get();
	}

	@Override
	public Contact updateContact(UpdateContactDto dto) {
		UUID id = dto.getContactId();
		Optional<Contact> optionalContact = repository.findById(id);
		
		if(!optionalContact.isPresent()) {
			throw new NotFoundException(String.format("Could not find Contact with id %s", id));
		}		
		Contact contact = optionalContact.get();
		return contact.updateEntity(dto);
	}

	@Override
	public String deleteContact(UUID id) {
		Optional<Contact> optionalContact = repository.findById(id);
		
		if(!optionalContact.isPresent()) {
			throw new NotFoundException(String.format("Could not find Contact with id %s", id));
		}	
		
		Contact contact = optionalContact.get();
		repository.delete(contact);
		
		return String.format("Contact '%s' deleted successfully!", contact.getTitle());
	}
}
