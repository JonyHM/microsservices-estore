package br.gov.sp.fatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Address;
import br.gov.sp.fatec.model.User;
import br.gov.sp.fatec.repository.AddressRepository;
import br.gov.sp.fatec.repository.UserRepository;

@Service
public class AddressServiceImplement implements AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public List<Address> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public Address createAddress(Address address, Long userId) {
		Optional<User> user = userRepo.findById(userId);
		
		if(!user.isPresent()) {
			throw new RuntimeException("Usuário não encontrado!");
		}
		
		User foundUser = user.get();
		foundUser.getAddresses().add(address);
		userRepo.save(foundUser);
		
		address.setUser(foundUser);
		
		return repository.save(address);
	}
	
	@Override
	public Address getById(Long id) {
		Optional<Address> address = repository.findById(id);
		
		if(!address.isPresent()) {
			throw new RuntimeException("Endereço não encontrado");
		}
		
		return address.get();
	}

	@Override
	public Address getByUserId(Long userId) {
		Optional<Address> address = repository.findByUserId(userId);
		
		if(!address.isPresent()) {
			throw new RuntimeException("Endereço não encontrado");
		}
		
		return address.get();
	}
}
