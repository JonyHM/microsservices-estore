package br.gov.sp.fatec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {

	Optional<List<Address>> findByCustomerId(UUID customerId);
	Optional<Address> findByUserAddressId(String userAddressId);
}
