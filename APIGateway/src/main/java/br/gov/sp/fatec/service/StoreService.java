package br.gov.sp.fatec.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.model.common.BaseGraphQLReturn;
import br.gov.sp.fatec.model.common.Constants;
import br.gov.sp.fatec.model.common.QueryObject;
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
import br.gov.sp.fatec.service.manager.RequestManager;

@Service
public class StoreService {

	@Value("${service.store.url}")
	private String urlString;
	
	@Autowired
	private RequestManager manager;
	
	/** PRODUCT **/
   
    public ResponseEntity<BaseGraphQLReturn<GetProductsData>> getProducts() {
    	String payload = String.format("{ getProducts { %s, price %s, attributes %s } }", 
    			Constants.PRODUCT_QUERY, 
    			Constants.PRICE_DETAIL_QUERY, 
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetProductsData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetProductByIdData>> getProductById(UUID id) {
    	String payload = String.format("{ getProductById(id: \"%s\") { %s, price %s, attributes %s } }", 
    			id,
    			Constants.PRODUCT_QUERY, 
    			Constants.PRICE_DETAIL_QUERY, 
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetProductByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateProductData>> createProduct(CreateProductDto dto) {
    	String priceBody = String.format("{ currency: \"%s\", amount: %s }", 
    			dto.getPrice().getCurrency(),
    			dto.getPrice().getAmount());
    	
    	String body = String.format("{ name: \"%s\", description: \"%s\", quantity: %s, "
    			+ "unavailableQuantity: %s, price: %s }", 
    			dto.getName(),
    			dto.getDescription(),
    			dto.getQuantity(),
    			dto.getUnavailableQuantity(),
    			priceBody);
    	
    	String payload = String.format("mutation { createProduct(product: %s) { %s, price %s, attributes %s } }", 
    			body, 
    			Constants.PRODUCT_QUERY, 
    			Constants.PRICE_DETAIL_QUERY, 
    			Constants.ATTRIBUTE_QUERY);
    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateProductData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateProductData>> updateProduct(UpdateProductDto dto) {
    	String priceBody = String.format("{ currency: \"%s\", amount: %s }", 
    			dto.getPrice().getCurrency(),
    			dto.getPrice().getAmount());
    	
    	String body = String.format("{ id: \"%s\", name: \"%s\", description: \"%s\", "
    			+ "quantity: %s, unavailableQuantity: %s, price: %s }",
    			dto.getId(),
    			dto.getName(),
    			dto.getDescription(),
    			dto.getQuantity(),
    			dto.getUnavailableQuantity(),
    			priceBody);
    	
    	String payload = String.format("mutation { updateProduct(product: %s) { %s, price %s, attributes %s } }", 
    			body, 
    			Constants.PRODUCT_QUERY, 
    			Constants.PRICE_DETAIL_QUERY, 
    			Constants.ATTRIBUTE_QUERY);
    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateProductData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteProductData>> deleteProduct(UUID id) {
    	String payload = String.format("mutation { deleteProduct(productId: \"%s\") }", id);
    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteProductData.class), 
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
    
    public ResponseEntity<BaseGraphQLReturn<GetPriceByProductIdData>> getPriceByProductId(UUID id) {
    	String payload = String.format("{ getPriceByProductId(productId: \"%s\") %s }", 
    			id,
    			Constants.PRICE_DETAIL_QUERY);

    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetPriceByProductIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreatePriceData>> createPrice(CreateStorePriceDto dto) {
    	String body = String.format("{ currency: \"%s\", amount: %s, productId: \"%s\" }", 
    			dto.getCurrency(),
    			dto.getAmount(),
    			dto.getProductId());
    	
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
    
    /** ATTRIBUTE **/
    
    public ResponseEntity<BaseGraphQLReturn<GetAttributesData>> getAttributes() {
    	String payload = String.format("{ getAttributes %s }", 
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAttributesData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAttributeByIdData>> getAttributeById(UUID id) {
    	String payload = String.format("{ getAttributeById(id: \"%s\") %s }", 
    			id,
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAttributeByIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<GetAttributesByProductIdData>> getAttributesByProductId(UUID id) {
    	String payload = String.format("{ getAttributesByProductId(productId: \"%s\") %s }", 
    			id,
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(GetAttributesByProductIdData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<CreateAttributeData>> createAttribute(CreateAttributeDto dto) {
    	String body = String.format("{ name: \"%s\", value: \"%s\", productId: \"%s\" }", 
    			dto.getName(),
    			dto.getValue(),
    			dto.getProductId());
    	
    	String payload = String.format("mutation { createAttribute(attribute: %s) %s }", 
    			body, 
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(CreateAttributeData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<UpdateAttributeData>> updateAttribute(UpdateAttributeDto dto) {
    	String body = String.format("{ name: \"%s\", value: \"%s\", attributeId: \"%s\", productId: \"%s\" }", 
    			dto.getName(),
    			dto.getValue(),
    			dto.getAttributeId(),
    			dto.getProductId());
    	
    	String payload = String.format("mutation { updateAttribute(attribute: %s) %s }", 
    			body, 
    			Constants.ATTRIBUTE_QUERY);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(UpdateAttributeData.class), 
    			new QueryObject(payload));
    }
    
    public ResponseEntity<BaseGraphQLReturn<DeleteAttributeData>> deleteAttribute(UUID id) {
    	String payload = String.format("mutation { deleteAttribute(attributeId: \"%s\") }", id);
    	    	
    	return manager.doPOST(
    			urlString, 
    			BaseGraphQLReturn.of(DeleteAttributeData.class), 
    			new QueryObject(payload));
    }
}
