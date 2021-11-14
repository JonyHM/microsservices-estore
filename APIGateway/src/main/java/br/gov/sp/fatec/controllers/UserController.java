package br.gov.sp.fatec.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.gov.sp.fatec.model.common.BaseGraphQLReturn;
import br.gov.sp.fatec.model.userMicroservice.address.data.CreateAddressData;
import br.gov.sp.fatec.model.userMicroservice.address.data.DeleteAddressData;
import br.gov.sp.fatec.model.userMicroservice.address.data.GetAddressByIdData;
import br.gov.sp.fatec.model.userMicroservice.address.data.GetAddressesData;
import br.gov.sp.fatec.model.userMicroservice.address.data.UpdateAddressData;
import br.gov.sp.fatec.model.userMicroservice.address.dto.CreateAddressDto;
import br.gov.sp.fatec.model.userMicroservice.address.dto.UpdateAddressDto;
import br.gov.sp.fatec.model.userMicroservice.contact.data.CreateContactData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.DeleteContactData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.GetContactByIdData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.GetContactsData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.UpdateContactData;
import br.gov.sp.fatec.model.userMicroservice.contact.dto.CreateContactDto;
import br.gov.sp.fatec.model.userMicroservice.contact.dto.UpdateContactDto;
import br.gov.sp.fatec.model.userMicroservice.user.data.CreateUserData;
import br.gov.sp.fatec.model.userMicroservice.user.data.DeleteUserData;
import br.gov.sp.fatec.model.userMicroservice.user.data.GetUserByIdData;
import br.gov.sp.fatec.model.userMicroservice.user.data.GetUsersData;
import br.gov.sp.fatec.model.userMicroservice.user.data.UpdateUserData;
import br.gov.sp.fatec.model.userMicroservice.user.dto.CreateUserDto;
import br.gov.sp.fatec.model.userMicroservice.user.dto.UpdateUserDto;
import br.gov.sp.fatec.service.UserService;

@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class UserController {

	@Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<BaseGraphQLReturn<GetUsersData>> getUsers() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetUsersData>> response = service.getUsers();
    	return response;
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetUserByIdData>> getUsersById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetUserByIdData>> response = service.getUserById(id);
    	return response;
    }
    
    @PostMapping
    public ResponseEntity<BaseGraphQLReturn<CreateUserData>> createUser(@RequestBody CreateUserDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreateUserData>> response = service.createUser(dto);
    	return response;
    }
    
    @PatchMapping
    public ResponseEntity<BaseGraphQLReturn<UpdateUserData>> updateUser(@RequestBody UpdateUserDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdateUserData>> response = service.updateUser(dto);
    	return response;
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteUserData>> deleteUser(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<DeleteUserData>> response = service.deleteUser(id);
    	return response;
    }
    
    @GetMapping(value = "/address")
    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetAddressesData>> response = service.getAddresses();
    	return response;
    }
    
    @GetMapping(value = "/address/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressesById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> response = service.getAddressById(id);
    	return response;
    }
    
    @PostMapping(value = "/address")
    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(@RequestBody CreateAddressDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreateAddressData>> response = service.createAddress(dto);
    	return response;
    }
    
    @PatchMapping(value = "address")
    public ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> updateAddress(@RequestBody UpdateAddressDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> response = service.updateAddress(dto);
    	return response;
    }
    
    @DeleteMapping(value = "/address/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> deleteAddress(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> response = service.deleteAddress(id);
    	return response;
    }
    
    @GetMapping(value = "/contact")
    public ResponseEntity<BaseGraphQLReturn<GetContactsData>> getContacts() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetContactsData>> response = service.getContacts();
    	return response;
    }
    
    @GetMapping(value = "/contact/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> getContactById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> response = service.getContactById(id);
    	return response;
    }
    
    @PostMapping(value = "/contact")
    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(@RequestBody CreateContactDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreateContactData>> response = service.createContact(dto);
    	return response;
    }
    
    @PatchMapping(value = "contact")
    public ResponseEntity<BaseGraphQLReturn<UpdateContactData>> updateContact(@RequestBody UpdateContactDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdateContactData>> response = service.updateContact(dto);
    	return response;
    }
    
    @DeleteMapping(value = "/contact/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteContactData>> deleteContact(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<DeleteContactData>> response = service.deleteContact(id);
    	return response;
    }
}
