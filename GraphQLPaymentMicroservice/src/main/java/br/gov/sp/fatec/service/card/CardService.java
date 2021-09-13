package br.gov.sp.fatec.service.card;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Card;
import br.gov.sp.fatec.model.dto.CreateCardDto;
import javassist.NotFoundException;

public interface CardService {

	public List<Card> getAll();
	public Card createCard(CreateCardDto dto) throws NotFoundException;
	public Card getById(UUID id) throws NotFoundException;
	public List<Card> getByCustomerId(UUID customerId) throws NotFoundException;
}
