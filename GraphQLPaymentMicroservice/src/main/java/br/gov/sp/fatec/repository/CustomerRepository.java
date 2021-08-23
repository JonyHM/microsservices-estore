package br.gov.sp.fatec.repository;

import java.rmi.server.UID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UID> {

}
