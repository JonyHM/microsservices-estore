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

import br.gov.sp.fatec.model.BaseGraphQLReturn;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.CreateCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.DeleteCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByCPFData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomerByUserIdData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.GetCustomersData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.data.UpdateCustomerData;
import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.CreateCustomerDto;
import br.gov.sp.fatec.model.paymentMicroservice.customer.dto.UpdateCustomerDto;
import br.gov.sp.fatec.service.PaymentService;

@RestController
@RequestMapping(value = "payment")
@CrossOrigin
public class PaymentController { 
	
	@Autowired
	private PaymentService service;

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
    
    @GetMapping(value = "customer/userId/{userId}")
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
    
//    @GetMapping(value = "/address")
//    public ResponseEntity<BaseGraphQLReturn<GetAddressesData>> getAddresses() throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<GetAddressesData>> response = service.getAddresses();
//    	return response;
//    }
//    
//    @GetMapping(value = "/address/{id}")
//    public ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> getAddressesById(@PathVariable UUID id) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<GetAddressByIdData>> response = service.getAddressById(id);
//    	return response;
//    }
//    
//    @PostMapping(value = "/address")
//    public ResponseEntity<BaseGraphQLReturn<CreateAddressData>> createAddress(@RequestBody CreateAddressDto dto) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<CreateAddressData>> response = service.createAddress(dto);
//    	return response;
//    }
//    
//    @PatchMapping(value = "address")
//    public ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> updateAddress(@RequestBody UpdateAddressDto dto) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<UpdateAddressData>> response = service.updateAddress(dto);
//    	return response;
//    }
//    
//    @DeleteMapping(value = "/address/{id}")
//    public ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> deleteAddress(@PathVariable UUID id) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<DeleteAddressData>> response = service.deleteAddress(id);
//    	return response;
//    }
//    
//    @GetMapping(value = "/contact")
//    public ResponseEntity<BaseGraphQLReturn<GetContactsData>> getContacts() throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<GetContactsData>> response = service.getContacts();
//    	return response;
//    }
//    
//    @GetMapping(value = "/contact/{id}")
//    public ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> getContactById(@PathVariable UUID id) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<GetContactByIdData>> response = service.getContactById(id);
//    	return response;
//    }
//    
//    @PostMapping(value = "/contact")
//    public ResponseEntity<BaseGraphQLReturn<CreateContactData>> createContact(@RequestBody CreateContactDto dto) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<CreateContactData>> response = service.createContact(dto);
//    	return response;
//    }
//    
//    @PatchMapping(value = "contact")
//    public ResponseEntity<BaseGraphQLReturn<UpdateContactData>> updateContact(@RequestBody UpdateContactDto dto) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<UpdateContactData>> response = service.updateContact(dto);
//    	return response;
//    }
//    
//    @DeleteMapping(value = "/contact/{id}")
//    public ResponseEntity<BaseGraphQLReturn<DeleteContactData>> deleteContact(@PathVariable UUID id) throws JsonProcessingException { 
//    	ResponseEntity<BaseGraphQLReturn<DeleteContactData>> response = service.deleteContact(id);
//    	return response;
//    }
}
