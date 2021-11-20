package br.gov.sp.fatec.service.card;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.model.dto.card.CreateCardDto;
import br.gov.sp.fatec.model.dto.card.UpdateCardDto;

public interface CardService {

	public List<Card> getAll();
	public Card getById(UUID id);
	public List<Card> getByCustomerId(UUID customerId);
	public Card createCard(CreateCardDto dto);
	public Card updateCard(UpdateCardDto dto);
	public String deleteCard(UUID id);
}
