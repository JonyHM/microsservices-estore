package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.contact.CreateContactDto;
import br.gov.sp.fatec.model.dto.contact.CreatekafkaContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateContactDto;
import br.gov.sp.fatec.model.dto.contact.UpdateKafkaContactDto;
import br.gov.sp.fatec.repository.ContactRepository;
import br.gov.sp.fatec.repository.CustomerRepository;

@Service
public class ContactServiceImplement implements ContactService {

	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public List<Contact> getAll() {
		return repository.findAll();
	}

	@Override
	public Contact createContact(CreateContactDto dto) {
		Optional<Customer> optionalCustomer = Optional.of(new Customer());
		
		if(dto.getCustomerId() != null) {			
			optionalCustomer = customerRepo.findById(dto.getCustomerId());
		} else {
			optionalCustomer = customerRepo.findByUserId(dto.getUserId());
		}
		
		Contact contact = new Contact(dto);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			contact.setCustomer(customer);
			Contact newContact = repository.save(contact);
			
			Set<Contact> contacts = customer.getContacts();
			contacts.add(newContact);
			customer.setContacts(contacts);
			customerRepo.save(customer);
			return newContact;
		}		
		throw new NotFoundException(String.format("Could not find Contact with id '%s'!", dto.getCustomerId()));
	}
	
	@Override
	public Contact createKafkaContact(CreatekafkaContactDto dto) {
		Optional<Customer> optionalCustomer = customerRepo.findByUserId(dto.getUserId());
				
		Contact contact = new Contact(dto);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			contact.setCustomer(customer);
			Contact newContact = repository.save(contact);
			
			Set<Contact> contacts = customer.getContacts();
			contacts.add(newContact);
			customer.setContacts(contacts);
			customerRepo.save(customer);
			return newContact;
		}		
		throw new NotFoundException(String.format("Could not find Contact with user id '%s'!", dto.getUserId()));
	}

	@Override
	public Contact getById(UUID id) {
		Optional<Contact> optionalContact = repository.findById(id);
		
		if(optionalContact.isPresent()) {
			return optionalContact.get();
		}
		throw new NotFoundException(String.format("Could not find Contact with id '%s'!", id));
	}

	@Override
	public List<Contact> getByCustomerId(UUID customerId) {
		Optional<List<Contact>> optionalContacts = repository.findByCustomerId(customerId);
		
		if(optionalContacts.isPresent()) {
			return optionalContacts.get();
		}		
		throw new NotFoundException(String.format("There is no contacts for customers with id '%s'", customerId));
	}

	@Override
	public Contact updateContact(UpdateContactDto dto) {
		UUID id = dto.getContactId();
		Optional<Contact> optionalContact = repository.findById(id);
		
		if(optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			return repository.save(contact.updateEntity(dto));
		}
		throw new NotFoundException(String.format("Could not find Contact with id '%s'!", id));
	}
	
	@Override
	public Contact updateKafkaContact(UpdateKafkaContactDto dto) {
		UUID id = dto.getUserContactId();
		Optional<Contact> optionalContact = repository.findByUserContactId(id);
		
		if(optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			return repository.save(contact.updateEntity(dto));
		}
		throw new NotFoundException(String.format("Could not find Contact with id '%s'!", id));
	}

	@Override
	public String deleteContact(UUID id) {
		Optional<Contact> optionalContact = repository.findById(id);
		
		if(optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			repository.delete(contact);
			return String.format("Contact '%s' deleted successfully!", contact.getTitle());
		}
		throw new NotFoundException(String.format("Could not find Contact with id '%s'!", id));
	}

	@Override
	public String deleteByUserContactId(UUID id) {
		Optional<Contact> optionalContact = repository.findByUserContactId(id);
		
		if(optionalContact.isPresent()) {
			Contact contact = optionalContact.get();
			repository.delete(contact);
			return String.format("Contact '%s' deleted successfully!", contact.getTitle());
		}
		throw new NotFoundException(String.format("Could not find Contact with id '%s'!", id));
	}
}
