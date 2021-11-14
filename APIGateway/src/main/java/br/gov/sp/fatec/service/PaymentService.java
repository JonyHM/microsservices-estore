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

import br.gov.sp.fatec.model.common.BaseGraphQLReturn;
import br.gov.sp.fatec.model.common.Constants;
import br.gov.sp.fatec.model.common.QueryObject;
import br.gov.sp.fatec.model.paymentMicroservice.address.data.GetAddressByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.address.data.GetAddressesByCustomerIdData;
import br.gov.sp.fatec.model.paymentMicroservice.address.data.GetAddressesData;
import br.gov.sp.fatec.model.paymentMicroservice.address.dto.CreateAddressDto;
import br.gov.sp.fatec.model.paymentMicroservice.card.data.CreateCardData;
import br.gov.sp.fatec.model.paymentMicroservice.card.data.DeleteCardData;
import br.gov.sp.fatec.model.paymentMicroservice.card.data.GetCardByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.card.data.GetCardsByCustomerIdData;
import br.gov.sp.fatec.model.paymentMicroservice.card.data.GetCardsData;
import br.gov.sp.fatec.model.paymentMicroservice.card.data.UpdateCardData;
import br.gov.sp.fatec.model.paymentMicroservice.card.dto.CreateCardDto;
import br.gov.sp.fatec.model.paymentMicroservice.card.dto.UpdateCardDto;
import br.gov.sp.fatec.model.paymentMicroservice.contact.data.GetContactsByCustomerIdData;
import br.gov.sp.fatec.model.paymentMicroservice.contact.dto.CreateContactDto;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.CreateCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.DeleteCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByCPFData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByUserIdData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomersData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.UpdateCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CreateCustomerDto;
import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.UpdateCustomerDto;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.CancelOrderData;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.CreateOrderData;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.GetOrderByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.GetOrdersByCustomerIdData;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.GetOrdersData;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.PayOrderData;
import br.gov.sp.fatec.model.paymentMicroservice.order.data.UpdateOrderData;
import br.gov.sp.fatec.model.paymentMicroservice.order.dto.CreateOrderDto;
import br.gov.sp.fatec.model.paymentMicroservice.order.dto.UpdateOrderDto;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.CreatePriceData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.DeletePriceData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.GetPriceByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.GetPriceByOrderIdData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.GetPricesData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.UpdatePriceData;
import br.gov.sp.fatec.model.paymentMicroservice.price.dto.CreatePriceDto;
import br.gov.sp.fatec.model.paymentMicroservice.price.dto.UpdatePriceDto;
import br.gov.sp.fatec.model.userMicroservice.address.data.CreateAddressData;
import br.gov.sp.fatec.model.userMicroservice.address.data.DeleteAddressData;
import br.gov.sp.fatec.model.userMicroservice.address.data.UpdateAddressData;
import br.gov.sp.fatec.model.userMicroservice.address.dto.UpdateAddressDto;
import br.gov.sp.fatec.model.userMicroservice.contact.data.CreateContactData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.DeleteContactData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.GetContactByIdData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.GetContactsData;
import br.gov.sp.fatec.model.userMicroservice.contact.data.UpdateContactData;
import br.gov.sp.fatec.model.userMicroservice.contact.dto.UpdateContactDto;

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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getAddresses %s }", 
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetAddressByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressesByCustomerIdData>> getAddressesByCustomerId(UUID customerId) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getAddressesByCustomerId(customerId: \"%s\") %s }", 
    			customerId, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetAddressesByCustomerIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(CreateAddressDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ street: \"%s\", number: \"%s\", district: \"%s\", complement: \"%s\", "
    			+ "city: \"%s\", state: \"%s\", country: \"%s\", customerId: \"%s\" }", 
    			dto.getStreet(), 
    			dto.getNumber(), 
    			dto.getDistrict(),
    			dto.getComplement(),
    			dto.getCity(),
    			dto.getState(),
    			dto.getCountry(),
    			dto.getCustomerId());
    	
    	String payload = String.format("mutation { createAddress(address: %s) %s }", 
    			body, 
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_ADDRESS_QUERY);
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
    			Constants.PAYMENT_CONTACTS_QUERY);
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
    			Constants.PAYMENT_CONTACTS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetContactByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetContactsByCustomerIdData>> getContactsByCustomerId(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("{ getContactsByCustomerId(customerId: \"%s\") %s }", 
    			id, 
    			Constants.PAYMENT_CONTACTS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetContactsByCustomerIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(CreateContactDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", customerId: \"%s\"}", 
    			dto.getTitle(), 
    			dto.getType(), 
    			dto.getValue(),
    			dto.getCustomerId());
    	
    	String payload = String.format("mutation { createContact(contact: %s) %s }", 
    			body, 
    			Constants.PAYMENT_CONTACTS_QUERY);
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
    			Constants.PAYMENT_CONTACTS_QUERY);
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
    
    /** CARDS **/
    
    public ResponseEntity<BaseGraphQLReturn<GetCardsData>> getCards() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getCards %s }", 
    			Constants.CARDS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCardsData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCardByIdData>> getCardById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getCardById(id: \"%s\") %s }", 
    			id,
    			Constants.CARDS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCardByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCardsByCustomerIdData>> getCardsByCustomerId(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getCardsByCustomerId(customerId: \"%s\") %s }", 
    			id,
    			Constants.CARDS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetCardsByCustomerIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateCardData>> createCard(CreateCardDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");  
    	
    	
    	String body = String.format("{ nickname: \"%s\", holderName: \"%s\", number: \"%s\", "
    			+ "cvv: \"%s\", expirationDate: \"%s\", holderId: \"%s\"}", 
    			dto.getNickname(),
    			dto.getHolderName(),
    			dto.getNumber(),
    			dto.getCvv(),
    			dto.getExpirationDate(),
    			dto.getHolderId());
    	
    	String payload = String.format("mutation { createCard(card: %s) %s }", 
    			body, 
    			Constants.CARDS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreateCardData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateCardData>> updateCard(UpdateCardDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String body = String.format("{ nickname: \"%s\", holderName: \"%s\", number: \"%s\", "
    			+ "cvv: \"%s\", expirationDate: \"%s\", cardId: \"%s\"}", 
    			dto.getNickname(),
    			dto.getHolderName(),
    			dto.getNumber(),
    			dto.getCvv(),
    			dto.getExpirationDate(),
    			dto.getCardId());
    	
    	String payload = String.format("mutation { updateContact(contact: %s) %s }", 
    			body, 
    			Constants.CARDS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdateCardData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteCardData>> deleteCard(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("mutation { deleteCard(cardId: \"%s\") }", id);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(DeleteCardData.class)
        		);
    }
    
    /** ORDERS **/
    
    public ResponseEntity<BaseGraphQLReturn<GetOrdersData>> getOrders() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getOrders %s }", 
    			Constants.ORDERS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetOrdersData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetOrderByIdData>> getOrderById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getOrderById(id: \"%s\") %s }", 
    			id,
    			Constants.ORDERS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetOrderByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetOrdersByCustomerIdData>> getOrdersByCustomerId(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getOrdersByCustomerId(customerId: \"%s\") %s }", 
    			id,
    			Constants.ORDERS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetOrdersByCustomerIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateOrderData>> createOrder(CreateOrderDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");  
    	
    	String priceBody = String.format("{ currency: \"%s\", amount: %s }", 
    			dto.getPrice().getCurrency(),
    			dto.getPrice().getAmount());
    	
    	String body = String.format("{ cartId: \"%s\", userId: \"%s\", description: \"%s\", "
    			+ "price: %s }", 
    			dto.getCartId(),
    			dto.getUserId(),
    			dto.getDescription(),
    			priceBody);
    	
    	String payload = String.format("mutation { createOrder(order: %s) %s }", 
    			body, 
    			Constants.ORDERS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreateOrderData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateOrderData>> updateOrder(UpdateOrderDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");  
    	
    	String body = String.format("{ orderId: \"%s\", description: \"%s\" }", 
    			dto.getOrderId(),
    			dto.getDescription());
    	
    	String payload = String.format("mutation { updateOrder(order: %s) %s }", 
    			body, 
    			Constants.ORDERS_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdateOrderData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<PayOrderData>> payOrder(UUID id, UUID cardId, UUID cartId) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	

    	String payment = String.format("{ orderId: \"%s\", cardId: \"%s\", "
    			+ "cartId: \"%s\" }", 
    			id, 
    			cardId, 
    			cartId);
    	String payload = String.format("mutation { payOrder(payment: %s) }", payment);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(PayOrderData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CancelOrderData>> cancelOrder(UUID id, UUID cardId, UUID cartId) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	

    	String payment = String.format("{ orderId: \"%s\", cardId: \"%s\", "
    			+ "cartId: \"%s\" }", 
    			id, 
    			cardId, 
    			cartId);
    	String payload = String.format("mutation { cancelOrder(payment: %s) }", payment);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CancelOrderData.class)
        		);
    }
    
    /** PRICE **/
    
    public ResponseEntity<BaseGraphQLReturn<GetPricesData>> getPrices() throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getPrices %s }", 
    			Constants.PRICE_DETAIL_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetPricesData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetPriceByIdData>> getPriceById(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getPriceById(id: \"%s\") %s }",
    			id,
    			Constants.PRICE_DETAIL_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetPriceByIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetPriceByOrderIdData>> getPriceByOrderId(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");
    	
    	String payload = String.format("{ getPriceByOrderId(orderId: \"%s\") %s }",
    			id,
    			Constants.PRICE_DETAIL_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(GetPriceByOrderIdData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreatePriceData>> createPrice(CreatePriceDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");  
    	
    	String body = String.format("{ currency: \"%s\", amount: %s, orderId: \"%s\" }", 
    			dto.getCurrency(),
    			dto.getAmount(),
    			dto.getOrderId());
    	
    	String payload = String.format("mutation { createPrice(price: %s) %s }", 
    			body, 
    			Constants.PRICE_DETAIL_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(CreatePriceData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdatePriceData>> updatePrice(UpdatePriceDto dto) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");  
    	
    	String body = String.format("{ currency: \"%s\", amount: %s, priceId: \"%s\" }", 
    			dto.getCurrency(),
    			dto.getAmount(),
    			dto.getPriceId());
    	
    	String payload = String.format("mutation { updatePrice(price: %s) %s }", 
    			body, 
    			Constants.PRICE_DETAIL_QUERY);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(UpdatePriceData.class)
        		);
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeletePriceData>> deletePrice(UUID id) throws JsonProcessingException {
    	headers.add("Content-type", "application/json");   	
    	
    	String payload = String.format("mutation { deletePrice(priceId: \"%s\") }", id);
    	String query = new ObjectMapper().writeValueAsString(new QueryObject(payload));
    	    	
        return restTemplate
        		.postForEntity(
        				urlString, 
        				new HttpEntity<>(query, headers), 
        				BaseGraphQLReturn.of(DeletePriceData.class)
        		);
    }
}
