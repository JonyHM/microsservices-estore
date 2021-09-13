package br.gov.sp.fatec.resolver.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.model.dto.CreateCardDto;
import br.gov.sp.fatec.service.card.CardService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import javassist.NotFoundException;

@Component
public class CardMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private CardService service;

	public Card createCard(CreateCardDto dto) throws NotFoundException {
		return service.createCard(dto);
	}
}
