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
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.CreateCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.DeleteCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByCPFData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByUserIdData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomersData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.UpdateCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CreateCustomerDto;
import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.UpdateCustomerDto;

@Service
public class PaymentService {

	@Value("${graphql.payment.url}")
	private String urlString;
	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers = new HttpHeaders();    
   
    public ResponseEntity<BaseGraphQLReturn<GetCustomersData>> getCustomers() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getCustomers { %s, contacts %s, addresses %s } }", 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCustomersData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByIdData>> getCustomerById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getCustomerById(id: \"%s\") { %s, contacts %s, addresses %s } }", 
    			id, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCustomerByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByCPFData>> getCustomerByCpf(String cpf) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getCustomerByCPF(cpf: \"%s\") { %s, contacts %s, addresses %s } }", 
    			cpf, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCustomerByCPFData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByUserIdData>> getCustomerByUserId(String userId) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getCustomerByUserId(userId: \"%s\") { %s, contacts %s, addresses %s } }", 
    			userId, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCustomerByUserIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateCustomerData>> createCustomer(CreateCustomerDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ userId: \"%s\", name: \"%s\", cpf: \"%s\" }", dto.getUserId(), dto.getName(), dto.getCpf());
    	String payload = String.format("mutation { createCustomer(customer: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreateCustomerData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateCustomerData>> updateCustomer(UpdateCustomerDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ customerId: \"%s\", name: \"%s\", cpf: \"%s\" }", 
    			dto.getCustomerId(), 
    			dto.getName(), 
    			dto.getCpf());
    	String payload = String.format("mutation { updateCustomer(customer: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdateCustomerData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteCustomerData>> deleteCustomer(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("mutation { deleteCustomer(customerId: \"%s\") }", id);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(DeleteCustomerData.class)
        		);
    }
    
//    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");
//    	
//    	String payload = String.format("{ getAddresses %s }", 
//    			Constants.ADDRESS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(GetAddressesData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressById(UUID id) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String payload = String.format("{ getAddressById(id: \"%s\") %s }", 
//    			id, 
//    			Constants.ADDRESS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(GetAddressByIdData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(CreateAddressDto dto) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String body = String.format("{ street: \"%s\", number: \"%s\", district: \"%s\", complement: \"%s\", "
//    			+ "city: \"%s\", state: \"%s\", country: \"%s\", userId: \"%s\" }", 
//    			dto.getStreet(), 
//    			dto.getNumber(), 
//    			dto.getDistrict(),
//    			dto.getComplement(),
//    			dto.getCity(),
//    			dto.getState(),
//    			dto.getCountry(),
//    			dto.getUserId());
//    	
//    	String payload = String.format("mutation { createAddress(address: %s) %s }", 
//    			body, 
//    			Constants.ADDRESS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(CreateAddressData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> updateAddress(UpdateAddressDto dto) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String body = String.format("{ street: \"%s\", number: \"%s\", district: \"%s\", complement: \"%s\", "
//    			+ "city: \"%s\", state: \"%s\", country: \"%s\", addressId: \"%s\" }", 
//    			dto.getStreet(), 
//    			dto.getNumber(), 
//    			dto.getDistrict(),
//    			dto.getComplement(),
//    			dto.getCity(),
//    			dto.getState(),
//    			dto.getCountry(),
//    			dto.getAddressId());
//    	
//    	String payload = String.format("mutation { updateAddress(address: %s) %s }", 
//    			body, 
//    			Constants.ADDRESS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(UpdateAddressData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> deleteAddress(UUID id) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String payload = String.format("mutation { deleteAddress(addressId: \"%s\") }", id);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(DeleteAddressData.class)
//        		);
//    }
//   
//    public ResponseEntity<BaseGraphQLReturn<GetContactsData>> getContacts() throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");
//    	
//    	String payload = String.format("{ getContacts %s }", 
//    			Constants.CONTACTS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(GetContactsData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> getContactById(UUID id) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String payload = String.format("{ getContactById(id: \"%s\") %s }", 
//    			id, 
//    			Constants.CONTACTS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(GetContactByIdData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(CreateContactDto dto) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", userId: \"%s\"}", 
//    			dto.getTitle(), 
//    			dto.getType(), 
//    			dto.getValue(),
//    			dto.getUserId());
//    	
//    	String payload = String.format("mutation { createContact(contact: %s) %s }", 
//    			body, 
//    			Constants.CONTACTS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(CreateContactData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<UpdateContactData>> updateContact(UpdateContactDto dto) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", contactId: \"%s\"}", 
//    			dto.getTitle(), 
//    			dto.getType(), 
//    			dto.getValue(),
//    			dto.getContactId());
//    	
//    	String payload = String.format("mutation { updateContact(contact: %s) %s }", 
//    			body, 
//    			Constants.CONTACTS_QUERY);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(UpdateContactData.class)
//        		);
//    }
//    
//    public ResponseEntity<BaseGraphQLReturn<DeleteContactData>> deleteContact(UUID id) throws JsonProcessingException {
//    	headers.add("Content-type", "application/json");   	
//    	
//    	String payload = String.format("mutation { deleteContact(contactId: \"%s\") }", id);
//    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
//    	    	
//        return restTemplate
//        		.postForEntity(
//        				urlString, 
//        				new HttpEntity<>(query, headers), 
//        				BaseGraphQLReturn.of(DeleteContactData.class)
//        		);
//    }
}
