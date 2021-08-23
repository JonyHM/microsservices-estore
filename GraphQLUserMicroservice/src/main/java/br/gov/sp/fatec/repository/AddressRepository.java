package br.gov.sp.fatec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByUserId(Long userId);
}
