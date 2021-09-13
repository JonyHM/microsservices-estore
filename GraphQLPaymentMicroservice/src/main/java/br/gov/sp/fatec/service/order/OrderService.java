package br.gov.sp.fatec.service.order;

import java.util.List;
import java.util.UUID;

import br.gov.sp.fatec.model.Order;
import br.gov.sp.fatec.model.dto.CreateOrderDto;
import javassist.NotFoundException;

public interface OrderService {

	public List<Order> getAll();
	public Order createOrder(CreateOrderDto dto) throws NotFoundException;
	public Order getById(UUID id) throws NotFoundException;
	public List<Order> getByCustomerId(UUID customerId) throws NotFoundException;
}
