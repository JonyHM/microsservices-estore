package br.gov.sp.fatec.service.order;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.dto.order.CreateOrderDto;
import br.gov.sp.fatec.model.dto.order.OrderManagementDto;
import br.gov.sp.fatec.model.dto.order.StartOrderDto;
import br.gov.sp.fatec.model.dto.order.UpdateOrderDto;

public interface OrderService {

	public List<Order> getAll();
	public Order getById(UUID id);
	public List<Order> getByCustomerId(UUID customerId);
	public Order createOrder(CreateOrderDto dto);
	public Order updateOrder(UpdateOrderDto dto);
	public String deleteOrder(UUID id);
	
	public void startOrder(StartOrderDto dto);
	public String payOrder(OrderManagementDto dto);
	public String cancelOrder(OrderManagementDto dto);
}
