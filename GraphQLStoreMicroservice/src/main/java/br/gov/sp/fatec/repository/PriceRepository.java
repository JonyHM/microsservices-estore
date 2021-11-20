package br.gov.sp.fatec.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

	Optional<Price> findByProductId(UUID productId);
}