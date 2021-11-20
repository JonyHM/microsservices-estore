package br.gov.sp.fatec.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.common.BaseGraphQLReturn;
import br.gov.sp.fatec.model.common.Constants;
import br.gov.sp.fatec.model.common.QueryObject;
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
import br.gov.sp.fatec.service.manager.RequestManager;

@Service
public class UserService {
	
	@Value("${service.user.url}")
	private String urlString;
	
	@Autowired
	private RequestManager manager;
   
    public ResponseEntity<BaseGraphQLReturn<GetUsersData>> getUsers() {
    	String payload = String.format("{ getUsers { %s, contacts %s, addresses %s } }", 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetUsersData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetUserByIdData>> getUserById(UUID id) {
    	String payload = String.format("{ getUserById(id: \"%s\") { %s, contacts %s, addresses %s } }", 
    			id, 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetUserByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateUserData>> createUser(CreateUserDto dto) {
    	String body = String.format("{ name: \"%s\", email: \"%s\", cpf: \"%s\" }", dto.getName(), dto.getEmail(), dto.getCpf());
    	String payload = String.format("mutation { createUser(user: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.USER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateUserData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateUserData>> updateUser(UpdateUserDto dto) {
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
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateUserData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteUserData>> deleteUser(UUID id) {
    	String payload = String.format("mutation { deleteUser(userId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteUserData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() {
    	String payload = String.format("{ getAddresses %s }", 
    			Constants.ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAddressesData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressById(UUID id) {
    	String payload = String.format("{ getAddressById(id: \"%s\") %s }", 
    			id, 
    			Constants.ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAddressByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(CreateAddressDto dto) {
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
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateAddressData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> updateAddress(UpdateAddressDto dto) {
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
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateAddressData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> deleteAddress(UUID id) {
    	String payload = String.format("mutation { deleteAddress(addressId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteAddressData.class), 
    			new QueryObject(payload));
    }
   
    public ResponseEntity<BaseGraphQLReturn<GetContactsData>> getContacts() {
    	String payload = String.format("{ getContacts %s }", 
    			Constants.CONTACTS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetContactsData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> getContactById(UUID id) {
    	String payload = String.format("{ getContactById(id: \"%s\") %s }", 
    			id, 
    			Constants.CONTACTS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetContactByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(CreateContactDto dto) {
    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", userId: \"%s\"}", 
    			dto.getTitle(), 
    			dto.getType(), 
    			dto.getValue(),
    			dto.getUserId());
    	
    	String payload = String.format("mutation { createContact(contact: %s) %s }", 
    			body, 
    			Constants.CONTACTS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateContactData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateContactData>> updateContact(UpdateContactDto dto) {
    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", contactId: \"%s\"}", 
    			dto.getTitle(), 
    			dto.getType(), 
    			dto.getValue(),
    			dto.getContactId());
    	
    	String payload = String.format("mutation { updateContact(contact: %s) %s }", 
    			body, 
    			Constants.CONTACTS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateContactData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteContactData>> deleteContact(UUID id) {
    	String payload = String.format("mutation { deleteContact(contactId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteContactData.class), 
    			new QueryObject(payload));
    }
}
