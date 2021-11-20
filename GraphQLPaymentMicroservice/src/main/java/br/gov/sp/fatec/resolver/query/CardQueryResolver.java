package br.gov.sp.fatec.resolver.query;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.service.card.CardService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import javassist.NotFoundException;

@Component
public class CardQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private CardService service;
	
	public List<Card> getCards() {
		return service.getAll();
	}
	
	public Card getCardById(UUID id) throws NotFoundException {
		return service.getById(id);
	}

	public List<Card> getCardsByCustomerId(UUID customerId) throws NotFoundException {
		return service.getByCustomerId(customerId);
	}
}
