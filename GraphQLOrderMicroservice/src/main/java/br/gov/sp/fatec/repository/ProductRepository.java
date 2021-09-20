package br.gov.sp.fatec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.OrderProduct;

public interface ProductRepository extends JpaRepository<OrderProduct, UUID> {

}
