package br.gov.sp.fatec.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {

	public Optional<Set<Contact>> findByUserId(UUID userId);
}
