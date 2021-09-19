package br.gov.sp.fatec.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, UUID> {

	Optional<Set<Attribute>> findByProductId(UUID productId);
}
