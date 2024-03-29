package br.gov.sp.fatec.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.sp.fatec.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
