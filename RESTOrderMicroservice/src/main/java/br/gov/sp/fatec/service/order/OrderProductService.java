package br.gov.sp.fatec.service.order;

import java.util.Set;
import java.util.UUID;

import br.gov.sp.fatec.model.OrderProduct;
import br.gov.sp.fatec.model.dto.orderProduct.CreateOrderProductDto;
import br.gov.sp.fatec.model.dto.orderProduct.UpdateOrderProductDto;

public interface OrderProductService {

	public Set<OrderProduct> findOrderProducts();
	public OrderProduct findOrderProductForProductId(String productId);
	public OrderProduct findOrderProduct(UUID id);
	public OrderProduct createOrderProduct(CreateOrderProductDto dto);
	public OrderProduct updateOrderProduct(UpdateOrderProductDto dto);
	public String deleteOrderProduct(UUID id);
}
