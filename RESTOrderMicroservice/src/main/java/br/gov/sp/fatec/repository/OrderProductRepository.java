package br.gov.sp.fatec.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID> {

	Optional<OrderProduct> findByProductId(String productId);
}
