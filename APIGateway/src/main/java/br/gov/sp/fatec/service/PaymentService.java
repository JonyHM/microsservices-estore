package br.gov.sp.fatec.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
import br.gov.sp.fatec.service.manager.RequestManager;

@Service
public class PaymentService {

	@Value("${service.payment.url}")
	private String urlString;
	
	@Autowired
	private RequestManager manager;
   
    public ResponseEntity<BaseGraphQLReturn<GetCustomersData>> getCustomers() {
    	String payload = String.format("{ getCustomers { %s, contacts %s, addresses %s } }", 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCustomersData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByIdData>> getCustomerById(UUID id) {
    	String payload = String.format("{ getCustomerById(id: \"%s\") { %s, contacts %s, addresses %s } }", 
    			id, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCustomerByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByCPFData>> getCustomerByCpf(String cpf) {
    	String payload = String.format("{ getCustomerByCPF(cpf: \"%s\") { %s, contacts %s, addresses %s } }", 
    			cpf, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCustomerByCPFData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByUserIdData>> getCustomerByUserId(String userId) {
    	String payload = String.format("{ getCustomerByUserId(userId: \"%s\") { %s, contacts %s, addresses %s } }", 
    			userId, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCustomerByUserIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateCustomerData>> createCustomer(CreateCustomerDto dto) {
    	String body = String.format("{ userId: \"%s\", name: \"%s\", cpf: \"%s\" }", dto.getUserId(), dto.getName(), dto.getCpf());
    	String payload = String.format("mutation { createCustomer(customer: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateCustomerData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateCustomerData>> updateCustomer(UpdateCustomerDto dto) {
    	String body = String.format("{ customerId: \"%s\", name: \"%s\", cpf: \"%s\" }", 
    			dto.getCustomerId(), 
    			dto.getName(), 
    			dto.getCpf());
    	String payload = String.format("mutation { updateCustomer(customer: %s)  { %s, contacts %s, addresses %s } }", 
    			body, 
    			Constants.CUSTOMER_QUERY, 
    			Constants.CONTACTS_QUERY, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateCustomerData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteCustomerData>> deleteCustomer(UUID id) {
    	String payload = String.format("mutation { deleteCustomer(customerId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteCustomerData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() {
    	String payload = String.format("{ getAddresses %s }", 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAddressesData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressById(UUID id) {
    	String payload = String.format("{ getAddressById(id: \"%s\") %s }", 
    			id, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAddressByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAddressesByCustomerIdData>> getAddressesByCustomerId(UUID customerId) {
    	String payload = String.format("{ getAddressesByCustomerId(customerId: \"%s\") %s }", 
    			customerId, 
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAddressesByCustomerIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(CreateAddressDto dto) {
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
    			Constants.PAYMENT_ADDRESS_QUERY);
    	    	
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
    			Constants.PAYMENT_CONTACTS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetContactsData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> getContactById(UUID id) {
    	String payload = String.format("{ getContactById(id: \"%s\") %s }", 
    			id, 
    			Constants.PAYMENT_CONTACTS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetContactByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetContactsByCustomerIdData>> getContactsByCustomerId(UUID id) {
    	String payload = String.format("{ getContactsByCustomerId(customerId: \"%s\") %s }", 
    			id, 
    			Constants.PAYMENT_CONTACTS_QUERY);
    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetContactsByCustomerIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(CreateContactDto dto) {
    	String body = String.format("{ title: \"%s\", type: \"%s\", value: \"%s\", customerId: \"%s\"}", 
    			dto.getTitle(), 
    			dto.getType(), 
    			dto.getValue(),
    			dto.getCustomerId());
    	
    	String payload = String.format("mutation { createContact(contact: %s) %s }", 
    			body, 
    			Constants.PAYMENT_CONTACTS_QUERY);
    	    	
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
    			Constants.PAYMENT_CONTACTS_QUERY);
    	    	
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
    
    /** CARDS **/
    
    public ResponseEntity<BaseGraphQLReturn<GetCardsData>> getCards() {
    	String payload = String.format("{ getCards %s }", 
    			Constants.CARDS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCardsData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCardByIdData>> getCardById(UUID id) {
    	String payload = String.format("{ getCardById(id: \"%s\") %s }", 
    			id,
    			Constants.CARDS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCardByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetCardsByCustomerIdData>> getCardsByCustomerId(UUID id) {
    	String payload = String.format("{ getCardsByCustomerId(customerId: \"%s\") %s }", 
    			id,
    			Constants.CARDS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetCardsByCustomerIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateCardData>> createCard(CreateCardDto dto) {
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
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateCardData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateCardData>> updateCard(UpdateCardDto dto) {
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
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateCardData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteCardData>> deleteCard(UUID id) {
    	String payload = String.format("mutation { deleteCard(cardId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteCardData.class), 
    			new QueryObject(payload));
    }
    
    /** ORDERS **/
    
    public ResponseEntity<BaseGraphQLReturn<GetOrdersData>> getOrders() {
    	String payload = String.format("{ getOrders %s }", 
    			Constants.ORDERS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetOrdersData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetOrderByIdData>> getOrderById(UUID id) {
    	String payload = String.format("{ getOrderById(id: \"%s\") %s }", 
    			id,
    			Constants.ORDERS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetOrderByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetOrdersByCustomerIdData>> getOrdersByCustomerId(UUID id) {
    	String payload = String.format("{ getOrdersByCustomerId(customerId: \"%s\") %s }", 
    			id,
    			Constants.ORDERS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetOrdersByCustomerIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateOrderData>> createOrder(CreateOrderDto dto) {
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
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateOrderData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateOrderData>> updateOrder(UpdateOrderDto dto) {
    	String body = String.format("{ orderId: \"%s\", description: \"%s\" }", 
    			dto.getOrderId(),
    			dto.getDescription());
    	
    	String payload = String.format("mutation { updateOrder(order: %s) %s }", 
    			body, 
    			Constants.ORDERS_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateOrderData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<PayOrderData>> payOrder(UUID id, UUID cardId, UUID cartId) {
    	String payment = String.format("{ orderId: \"%s\", cardId: \"%s\", "
    			+ "cartId: \"%s\" }", 
    			id, 
    			cardId, 
    			cartId);
    	String payload = String.format("mutation { payOrder(payment: %s) }", payment);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(PayOrderData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CancelOrderData>> cancelOrder(UUID id, UUID cardId, UUID cartId) {
    	String payment = String.format("{ orderId: \"%s\", cardId: \"%s\", "
    			+ "cartId: \"%s\" }", 
    			id, 
    			cardId, 
    			cartId);
    	String payload = String.format("mutation { cancelOrder(payment: %s) }", payment);

    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CancelOrderData.class), 
    			new QueryObject(payload));
    }
    
    /** PRICE **/
    
    public ResponseEntity<BaseGraphQLReturn<GetPricesData>> getPrices() {
    	String payload = String.format("{ getPrices %s }", 
    			Constants.PRICE_DETAIL_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetPricesData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetPriceByIdData>> getPriceById(UUID id) {
    	String payload = String.format("{ getPriceById(id: \"%s\") %s }",
    			id,
    			Constants.PRICE_DETAIL_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetPriceByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetPriceByOrderIdData>> getPriceByOrderId(UUID id) {
    	String payload = String.format("{ getPriceByOrderId(orderId: \"%s\") %s }",
    			id,
    			Constants.PRICE_DETAIL_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetPriceByOrderIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreatePriceData>> createPrice(CreatePriceDto dto) {
    	String body = String.format("{ currency: \"%s\", amount: %s, orderId: \"%s\" }", 
    			dto.getCurrency(),
    			dto.getAmount(),
    			dto.getOrderId());
    	
    	String payload = String.format("mutation { createPrice(price: %s) %s }", 
    			body, 
    			Constants.PRICE_DETAIL_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreatePriceData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdatePriceData>> updatePrice(UpdatePriceDto dto) {
    	String body = String.format("{ currency: \"%s\", amount: %s, priceId: \"%s\" }", 
    			dto.getCurrency(),
    			dto.getAmount(),
    			dto.getPriceId());
    	
    	String payload = String.format("mutation { updatePrice(price: %s) %s }", 
    			body, 
    			Constants.PRICE_DETAIL_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdatePriceData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeletePriceData>> deletePrice(UUID id) {
    	String payload = String.format("mutation { deletePrice(priceId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeletePriceData.class), 
    			new QueryObject(payload));
    }
}
