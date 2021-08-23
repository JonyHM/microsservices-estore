package br.gov.sp.fatec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	public Optional<Contact> findByUserId(Long userId);
}
