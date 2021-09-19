package br.gov.sp.fatec.resolver.mutation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.model.dto.card.CreateCardDto;
import br.gov.sp.fatec.model.dto.card.UpdateCardDto;
import br.gov.sp.fatec.service.card.CardService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class CardMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private CardService service;

	public Card createCard(CreateCardDto card) throws NotFoundException {
		return service.createCard(card);
	}
	
	public Card updateCard(UpdateCardDto card) {
		return service.updateCard(card);
	}
	
	public String deleteCard(UUID cardId) {
		return service.deleteCard(cardId);
	}
}
