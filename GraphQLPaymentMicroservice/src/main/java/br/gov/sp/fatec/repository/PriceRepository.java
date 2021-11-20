package br.gov.sp.fatec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.Price;

public interface PriceRepository extends JpaRepository<Price, UUID> {
	
}
