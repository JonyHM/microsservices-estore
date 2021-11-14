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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.gov.sp.fatec.exceptions.AlreadyFinishedCart;
import br.gov.sp.fatec.exceptions.BadGraphQLRequest;
import br.gov.sp.fatec.model.common.BaseGraphQLReturn;
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
import br.gov.sp.fatec.service.PaymentService;

@RestController
@RequestMapping(value = "payment")
@CrossOrigin
public class PaymentController { 
	
	@Autowired
	private PaymentService service;
	
	/** CUSTOMER **/

	@GetMapping(value = "customer")
    public ResponseEntity<BaseGraphQLReturn<GetCustomersData>> getCustomers() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCustomersData>> response = service.getCustomers();
    	return response;
    }
    
    @GetMapping(value = "customer/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByIdData>> getCustomerById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCustomerByIdData>> response = service.getCustomerById(id);
    	return response;
    }
    
    @GetMapping(value = "customer/cpf/{cpf}")
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByCPFData>> getCustomerByCpf(@PathVariable String cpf) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCustomerByCPFData>> response = service.getCustomerByCpf(cpf);
    	return response;
    }
    
    @GetMapping(value = "customer/by-user/{userId}")
    public ResponseEntity<BaseGraphQLReturn<GetCustomerByUserIdData>> getCustomerByUserId(@PathVariable String userId) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCustomerByUserIdData>> response = service.getCustomerByUserId(userId);
    	return response;
    }
    
    @PostMapping(value = "customer")
    public ResponseEntity<BaseGraphQLReturn<CreateCustomerData>> createCustomer(@RequestBody CreateCustomerDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreateCustomerData>> response = service.createCustomer(dto);
    	return response;
    }
    
    @PatchMapping(value = "customer")
    public ResponseEntity<BaseGraphQLReturn<UpdateCustomerData>> updateCustomer(@RequestBody UpdateCustomerDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdateCustomerData>> response = service.updateCustomer(dto);
    	return response;
    }
    
    @DeleteMapping(value = "customer/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteCustomerData>> deleteCustomer(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<DeleteCustomerData>> response = service.deleteCustomer(id);
    	return response;
    }
    
    /** ADDRESS **/
    
    @GetMapping(value = "address")
    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetAddressesData>> response = service.getAddresses();
    	return response;
    }
    
    @GetMapping(value = "/address/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressesById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> response = service.getAddressById(id);
    	return response;
    }
    
    @GetMapping(value = "/address/by-customer/{customerId}")
    public ResponseEntity<BaseGraphQLReturn<GetAddressesByCustomerIdData>> getAddressesByCustomerId(@PathVariable UUID customerId) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetAddressesByCustomerIdData>> response = service.getAddressesByCustomerId(customerId);
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
    
    @GetMapping(value = "/contact/by-customer/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetContactsByCustomerIdData>> getContactsByCustomerId(@PathVariable UUID id) throws JsonProcessingException { 
		ResponseEntity<BaseGraphQLReturn<GetContactsByCustomerIdData>> response = service.getContactsByCustomerId(id);
		
		if(response.getBody().getData() == null) {
			throw new BadGraphQLRequest("Error sending request to GraphQL endpoint");
		}
		
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
    
    /** CARDS **/
    
    @GetMapping(value = "card")
    public ResponseEntity<BaseGraphQLReturn<GetCardsData>> getCards() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCardsData>> response = service.getCards();
    	return response;
    }
    
    @GetMapping(value = "card/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetCardByIdData>> getCardById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCardByIdData>> response = service.getCardById(id);
    	return response;
    }
    
    @GetMapping(value = "card/by-customer/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetCardsByCustomerIdData>> getCardsByCustomerId(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetCardsByCustomerIdData>> response = service.getCardsByCustomerId(id);
    	return response;
    }
    
    @PostMapping(value = "card")
    public ResponseEntity<BaseGraphQLReturn<CreateCardData>> createCard(@RequestBody CreateCardDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreateCardData>> response = service.createCard(dto);
    	return response;
    }
    
    @PatchMapping(value = "card")
    public ResponseEntity<BaseGraphQLReturn<UpdateCardData>> updateCard(@RequestBody UpdateCardDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdateCardData>> response = service.updateCard(dto);
    	return response;
    }
    
    @DeleteMapping(value = "/card/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteCardData>> deleteCard(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<DeleteCardData>> response = service.deleteCard(id);
    	return response;
    }
    
    /** ORDERS **/
    
    @GetMapping(value = "order")
    public ResponseEntity<BaseGraphQLReturn<GetOrdersData>> getOrders() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetOrdersData>> response = service.getOrders();
    	return response;
    }
    
    @GetMapping(value = "order/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetOrderByIdData>> getOrderById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetOrderByIdData>> response = service.getOrderById(id);
    	return response;
    }
    
    @GetMapping(value = "order/by-customer/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetOrdersByCustomerIdData>> getOrdersByCustomerId(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetOrdersByCustomerIdData>> response = service.getOrdersByCustomerId(id);
    	return response;
    }
    
    @PostMapping(value = "order")
    public ResponseEntity<BaseGraphQLReturn<CreateOrderData>> createOrder(@RequestBody CreateOrderDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreateOrderData>> response = service.createOrder(dto);
    	return response;
    }
    
    @PatchMapping(value = "order")
    public ResponseEntity<BaseGraphQLReturn<UpdateOrderData>> updateOrder(@RequestBody UpdateOrderDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdateOrderData>> response = service.updateOrder(dto);
    	return response;
    }
    
    @PostMapping(value = "/order/pay/{id}")
    public ResponseEntity<BaseGraphQLReturn<PayOrderData>> payOrder(
    		@PathVariable UUID id, 
    		@RequestParam UUID cardId, 
    		@RequestParam UUID cartId) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<PayOrderData>> response = service.payOrder(id, cardId, cartId);
    	
    	if(response.getBody().getData() == null) {
			throw new AlreadyFinishedCart("Error sending request to GraphQL endpoint");
		}
    	
    	return response;
    }
    
    @PostMapping(value = "/order/cancel/{id}")
    public ResponseEntity<BaseGraphQLReturn<CancelOrderData>> cancelOrder(
    		@PathVariable UUID id, 
    		@RequestParam UUID cardId, 
    		@RequestParam UUID cartId) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CancelOrderData>> response = service.cancelOrder(id, cardId, cartId);

    	if(response.getBody().getData() == null) {
			throw new AlreadyFinishedCart("Error sending request to GraphQL endpoint");
		}
    	
    	return response;
    }
    
    /** PRICE **/
    
    @GetMapping(value = "price")
    public ResponseEntity<BaseGraphQLReturn<GetPricesData>> getPrices() throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetPricesData>> response = service.getPrices();
    	return response;
    }
    
    @GetMapping(value = "price/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetPriceByIdData>> getPriceById(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetPriceByIdData>> response = service.getPriceById(id);
    	return response;
    }
    
    @GetMapping(value = "price/by-order/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetPriceByOrderIdData>> getPriceByOrderId(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<GetPriceByOrderIdData>> response = service.getPriceByOrderId(id);
    	return response;
    }
    
    @PostMapping(value = "price")
    public ResponseEntity<BaseGraphQLReturn<CreatePriceData>> createPrice(@RequestBody CreatePriceDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<CreatePriceData>> response = service.createPrice(dto);
    	return response;
    }
    
    @PatchMapping(value = "price")
    public ResponseEntity<BaseGraphQLReturn<UpdatePriceData>> updatePrice(@RequestBody UpdatePriceDto dto) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<UpdatePriceData>> response = service.updatePrice(dto);
    	return response;
    }
    
    @DeleteMapping(value = "price/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeletePriceData>> deletePrice(@PathVariable UUID id) throws JsonProcessingException { 
    	ResponseEntity<BaseGraphQLReturn<DeletePriceData>> response = service.deletePrice(id);
    	return response;
    }
}
