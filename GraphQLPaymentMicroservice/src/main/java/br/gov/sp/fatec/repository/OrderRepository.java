package br.gov.sp.fatec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.Order;

public interface OrderRepository extends JpaRepository<Order, UUID> {

	Optional<List<Order>> findByCustomerId(UUID customerId);
}
