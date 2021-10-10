package br.gov.sp.fatec.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.Cart;

public interface CartRepository extends JpaRepository<Cart, UUID> {

	Optional<Set<Cart>> findByUserId(UUID userId);
}
