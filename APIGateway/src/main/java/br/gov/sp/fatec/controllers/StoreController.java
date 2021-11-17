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

import br.gov.sp.fatec.model.common.BaseGraphQLReturn;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.CreatePriceData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.DeletePriceData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.GetPriceByIdData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.GetPricesData;
import br.gov.sp.fatec.model.paymentMicroservice.price.data.UpdatePriceData;
import br.gov.sp.fatec.model.paymentMicroservice.price.dto.UpdatePriceDto;
import br.gov.sp.fatec.model.storeMicroservice.attribute.data.CreateAttributeData;
import br.gov.sp.fatec.model.storeMicroservice.attribute.data.DeleteAttributeData;
import br.gov.sp.fatec.model.storeMicroservice.attribute.data.GetAttributeByIdData;
import br.gov.sp.fatec.model.storeMicroservice.attribute.data.GetAttributesByProductIdData;
import br.gov.sp.fatec.model.storeMicroservice.attribute.data.GetAttributesData;
import br.gov.sp.fatec.model.storeMicroservice.attribute.data.UpdateAttributeData;
import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.CreateAttributeDto;
import br.gov.sp.fatec.model.storeMicroservice.attribute.dto.UpdateAttributeDto;
import br.gov.sp.fatec.model.storeMicroservice.price.data.GetPriceByProductIdData;
import br.gov.sp.fatec.model.storeMicroservice.price.dto.CreateStorePriceDto;
import br.gov.sp.fatec.model.storeMicroservice.product.data.CreateProductData;
import br.gov.sp.fatec.model.storeMicroservice.product.data.DeleteProductData;
import br.gov.sp.fatec.model.storeMicroservice.product.data.GetProductByIdData;
import br.gov.sp.fatec.model.storeMicroservice.product.data.GetProductsData;
import br.gov.sp.fatec.model.storeMicroservice.product.data.UpdateProductData;
import br.gov.sp.fatec.model.storeMicroservice.product.dto.CreateProductDto;
import br.gov.sp.fatec.model.storeMicroservice.product.dto.UpdateProductDto;
import br.gov.sp.fatec.service.StoreService;

@RestController
@RequestMapping(value = "store")
@CrossOrigin
public class StoreController {

	@Autowired
	private StoreService service;
	
	/** PRODUCT **/

	@GetMapping(value = "product")
    public ResponseEntity<BaseGraphQLReturn<GetProductsData>> getProducts() { 
    	ResponseEntity<BaseGraphQLReturn<GetProductsData>> response = service.getProducts();
    	return response;
    }
    
    @GetMapping(value = "product/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetProductByIdData>> getProductById(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<GetProductByIdData>> response = service.getProductById(id);
    	return response;
    }
     
    @PostMapping(value = "product")
    public ResponseEntity<BaseGraphQLReturn<CreateProductData>> createProduct(@RequestBody CreateProductDto dto) { 
    	ResponseEntity<BaseGraphQLReturn<CreateProductData>> response = service.createProduct(dto);
    	return response;
    }
    
    @PatchMapping(value = "product")
    public ResponseEntity<BaseGraphQLReturn<UpdateProductData>> updateProduct(@RequestBody UpdateProductDto dto) { 
    	ResponseEntity<BaseGraphQLReturn<UpdateProductData>> response = service.updateProduct(dto);
    	return response;
    }
    
    @DeleteMapping(value = "product/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteProductData>> deleteProduct(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<DeleteProductData>> response = service.deleteProduct(id);
    	return response;
    }
    
    /** PRICE **/
    
    @GetMapping(value = "price")
    public ResponseEntity<BaseGraphQLReturn<GetPricesData>> getPrices() { 
    	ResponseEntity<BaseGraphQLReturn<GetPricesData>> response = service.getPrices();
    	return response;
    }
    
    @GetMapping(value = "price/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetPriceByIdData>> getPriceById(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<GetPriceByIdData>> response = service.getPriceById(id);
    	return response;
    }
    
    @GetMapping(value = "price/by-product/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetPriceByProductIdData>> getPriceByProductId(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<GetPriceByProductIdData>> response = service.getPriceByProductId(id);
    	return response;
    }
    
    @PostMapping(value = "price")
    public ResponseEntity<BaseGraphQLReturn<CreatePriceData>> createPrice(@RequestBody CreateStorePriceDto dto) { 
    	ResponseEntity<BaseGraphQLReturn<CreatePriceData>> response = service.createPrice(dto);
    	return response;
    }
    
    @PatchMapping(value = "price")
    public ResponseEntity<BaseGraphQLReturn<UpdatePriceData>> updatePrice(@RequestBody UpdatePriceDto dto) { 
    	ResponseEntity<BaseGraphQLReturn<UpdatePriceData>> response = service.updatePrice(dto);
    	return response;
    }
    
    @DeleteMapping(value = "price/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeletePriceData>> deletePrice(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<DeletePriceData>> response = service.deletePrice(id);
    	return response;
    }
    
    /** ATTRIBUTE **/
    
    @GetMapping(value = "attribute")
    public ResponseEntity<BaseGraphQLReturn<GetAttributesData>> getAttributes() { 
    	ResponseEntity<BaseGraphQLReturn<GetAttributesData>> response = service.getAttributes();
    	return response;
    }
    
    @GetMapping(value = "attribute/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetAttributeByIdData>> getAttributeById(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<GetAttributeByIdData>> response = service.getAttributeById(id);
    	return response;
    }
    
    @GetMapping(value = "attribute/by-product/{id}")
    public ResponseEntity<BaseGraphQLReturn<GetAttributesByProductIdData>> getAttributesByProductId(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<GetAttributesByProductIdData>> response = service.getAttributesByProductId(id);
    	return response;
    }
    
    @PostMapping(value = "attribute")
    public ResponseEntity<BaseGraphQLReturn<CreateAttributeData>> createAttribute(@RequestBody CreateAttributeDto dto) { 
    	ResponseEntity<BaseGraphQLReturn<CreateAttributeData>> response = service.createAttribute(dto);
    	return response;
    }
    
    @PatchMapping(value = "attribute")
    public ResponseEntity<BaseGraphQLReturn<UpdateAttributeData>> updateAttribute(@RequestBody UpdateAttributeDto dto) { 
    	ResponseEntity<BaseGraphQLReturn<UpdateAttributeData>> response = service.updateAttribute(dto);
    	return response;
    }
    
    @DeleteMapping(value = "attribute/{id}")
    public ResponseEntity<BaseGraphQLReturn<DeleteAttributeData>> deleteAttribute(@PathVariable UUID id) { 
    	ResponseEntity<BaseGraphQLReturn<DeleteAttributeData>> response = service.deleteAttribute(id);
    	return response;
    }
}
