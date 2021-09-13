package br.gov.sp.fatec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {

	Optional<List<Contact>> findByCustomerId(UUID customerId);
}
