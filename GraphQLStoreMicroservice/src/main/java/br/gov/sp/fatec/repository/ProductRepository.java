package br.gov.sp.fatec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
