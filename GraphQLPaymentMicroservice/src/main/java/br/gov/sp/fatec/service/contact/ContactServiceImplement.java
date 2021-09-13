package br.gov.sp.fatec.service.contact;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.Contact;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.CreateContactDto;
import br.gov.sp.fatec.repository.ContactRepository;
import br.gov.sp.fatec.repository.CustomerRepository;
import javassist.NotFoundException;

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
	public Contact createContact(CreateContactDto dto) throws NotFoundException {
		Optional<Customer> optionalCustomer = customerRepo.findById(dto.getCustomerId());
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
		throw new NotFoundException(String.format("Customer with id %s does not exists!", dto.getCustomerId()));
	}

	@Override
	public Contact getById(UUID id) throws NotFoundException {
		Optional<Contact> optionalContact = repository.findById(id);
		
		if(optionalContact.isPresent()) {
			return optionalContact.get();
		}
		throw new NotFoundException(String.format("Contact with id %s does not exists!", id));
	}

	@Override
	public List<Contact> getByCustomerId(UUID customerId) throws NotFoundException {
		Optional<List<Contact>> optionalContacts = repository.findByCustomerId(customerId);
		
		if(optionalContacts.isPresent()) {
			return optionalContacts.get();
		}		
		throw new NotFoundException(String.format("There is no contacts for customers with id %s", customerId));
	}

}
