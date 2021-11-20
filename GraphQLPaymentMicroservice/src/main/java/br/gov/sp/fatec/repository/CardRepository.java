package br.gov.sp.fatec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

	Optional<List<Card>> findByHolderId(UUID holderId);
}
