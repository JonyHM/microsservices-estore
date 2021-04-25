package br.gov.sp.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
