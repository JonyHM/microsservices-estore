package br.gov.sp.fatec.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
public class User {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 40)
	private String name;
	
	@OneToMany(
    	mappedBy = "user",
		orphanRemoval = true,
        fetch = FetchType.LAZY
    )
	private Set<Address> addresses = new HashSet<Address>();
	
	@Column(length = 50)
	private String email;
	
	@Column(unique = true, length = 20)
	private String cpf;
	
	@OneToMany(
    	mappedBy = "user",
		orphanRemoval = true,
        fetch = FetchType.LAZY
    )
	private Set<Contact> contacts = new HashSet<Contact>();
}
