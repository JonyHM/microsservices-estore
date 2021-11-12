package br.gov.sp.fatec.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.model.BaseGraphQLReturn;
import br.gov.sp.fatec.model.Constants;
import br.gov.sp.fatec.model.QueryObject;
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

@Service
public class UserService {
	
	@Value("${graphql.user.url}")
	private String urlString;
	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = new HttpHeaders();    
   
    public ResponseEntity<BaseGraphQLReturn<GetUsersData>> getUsers() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getUsers { %s, contacts %s, addresses %s } }", 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetUsersData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetUserByIdData>> getUserById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getUserById(id: \"%s\") { %s, contacts %s, addresses %s } }", 
    			id, 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetUserByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateUserData>> createUser(CreateUserDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ name: \"%s\", email: \"%s\", cpf: \"%s\" }", dto.getName(), dto.getEmail(), dto.getCpf());
    	String payload = String.format("mutation { createUser(user: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreateUserData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateUserData>> updateUser(UpdateUserDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ userId: \"%s\", name: \"%s\", email: \"%s\", cpf: \"%s\" }", 
    			dto.getUserId(), 
    			dto.getName(), 
    			dto.getEmail(), 
    			dto.getCpf());
    	String payload = String.format("mutation { updateUser(user: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdateUserData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteUserData>> deleteUser(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("mutation { deleteUser(userId: \"%s\") }", id);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(DeleteUserData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getAddresses %s }", 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetAddressesData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getAddressById(id: \"%s\") %s }", 
    			id, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetAddressByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(CreateAddressDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ street: \"%s\", number: \"%s\", district: \"%s\", complement: \"%s\", "
    			+ "city: \"%s\", state: \"%s\", country: \"%s\", userId: \"%s\" }", 
    			dto.getStreet(), 
    			dto.getNumber(), 
    			dto.getDistrict(),
    			dto.getComplement(),
    			dto.getCity(),
    			dto.getState(),
    			dto.getCountry(),
    			dto.getUserId());
    	
    	String payload = String.format("mutation { createAddress(address: %s) %s }", 
    			body, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreateAddressData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> updateAddress(UpdateAddressDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ street: \"%s\", number: \"%s\", district: \"%s\", complement: \"%s\", "
    			+ "city: \"%s\", state: \"%s\", country: \"%s\", addressId: \"%s\" }", 
    			dto.getStreet(), 
    			dto.getNumber(), 
    			dto.getDistrict(),
    			dto.getComplement(),
    			dto.getCity(),
    			dto.getState(),
    			dto.getCountry(),
    			dto.getAddressId());
    	
    	String payload = String.format("mutation { updateAddress(address: %s) %s }", 
    			body, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdateAddressData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> deleteAddress(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("mutation { deleteAddress(addressId: \"%s\") }", id);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(DeleteAddressData.class)
        		);
    }
   
    public ResponseEntity<BaseGraphQLReturn<GetContactsData>> getContacts() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getContacts %s }", 
    			Constants.CONTACTS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetContactsData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> getContactById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getContactById(id: \"%s\") %s }", 
    			id, 
    			Constants.CONTACTS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetContactByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(CreateContactDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", userId: \"%s\"}", 
    			dto.getTitle(), 
    			dto.getType(), 
    			dto.getValue(),
    			dto.getUserId());
    	
    	String payload = String.format("mutation { createContact(contact: %s) %s }", 
    			body, 
    			Constants.CONTACTS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreateContactData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateContactData>> updateContact(UpdateContactDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", contactId: \"%s\"}", 
    			dto.getTitle(), 
    			dto.getType(), 
    			dto.getValue(),
    			dto.getContactId());
    	
    	String payload = String.format("mutation { updateContact(contact: %s) %s }", 
    			body, 
    			Constants.CONTACTS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdateContactData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteContactData>> deleteContact(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("mutation { deleteContact(contactId: \"%s\") }", id);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(DeleteContactData.class)
        		);
    }
}
