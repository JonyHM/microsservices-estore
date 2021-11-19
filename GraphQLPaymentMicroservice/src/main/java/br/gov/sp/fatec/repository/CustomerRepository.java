package br.gov.sp.fatec.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

	Optional<Customer> findByCpf(String cpf);
	Optional<Customer> findByUserId(String userId);
}
