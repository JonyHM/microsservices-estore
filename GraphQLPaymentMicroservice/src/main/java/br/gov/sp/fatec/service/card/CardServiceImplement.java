package br.gov.sp.fatec.service.card;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.exception.NotFoundException;
import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.model.Customer;
import br.gov.sp.fatec.model.dto.card.CreateCardDto;
import br.gov.sp.fatec.model.dto.card.UpdateCardDto;
import br.gov.sp.fatec.repository.CardRepository;
import br.gov.sp.fatec.repository.CustomerRepository;

@Service
public class CardServiceImplement implements CardService {
	
	@Autowired
	private CardRepository repository;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Card> getAll() {
		return repository.findAll();
	}

	@Override
	public Card createCard(CreateCardDto dto) {
		Optional<Customer> optionalCustomer = customerRepo.findById(dto.getHolderId());
		Card card = new Card(dto);
		
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			card.setHolder(customer);
			Card newCard = repository.save(card);
			
			Set<Card> cards = customer.getCards();
			cards.add(newCard);
			customer.setCards(cards);
			customerRepo.save(customer);
			return newCard;
		}
		throw new NotFoundException(String.format("Customer with id %s does not exist!", dto.getHolderId()));
	}

	@Override
	public Card getById(UUID id) {
		Optional<Card> optionalCard = repository.findById(id);
		
		if(optionalCard.isPresent()) {
			return optionalCard.get();
		}
		throw new NotFoundException(String.format("Could not find Card with id %s!", id));
	}

	@Override
	public List<Card> getByCustomerId(UUID customerId) {
		Optional<List<Card>> optionalCards = repository.findByHolderId(customerId);
		
		if(optionalCards.isPresent()) {
			return optionalCards.get();
		}
		throw new NotFoundException(String.format("Could not find Cards for customer with id %s!", customerId));
	}

	@Override
	public Card updateCard(UpdateCardDto dto) {
		UUID id = dto.getCardId();
		Optional<Card> optionalCard = repository.findById(id);
		
		if(optionalCard.isPresent()) {
			Card card = optionalCard.get(); 
			return repository.save(card.updateEntity(dto));
		}
		throw new NotFoundException(String.format("Could not find Card with id %s!", id));
	}

	@Override
	public String deleteCard(UUID id) {
		Optional<Card> optionalCard = repository.findById(id);
		
		if(optionalCard.isPresent()) {
			Card card = optionalCard.get();
			repository.delete(card);
			
			return String.format("Card '%s' deleted successfully!", card.getNickname());
		}
		throw new NotFoundException(String.format("Could not find Card with id %s!", id));
	}

}
