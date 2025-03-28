package br.inatel.dm112.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.inatel.dm112.model.Order;

public interface OrderInterface {

	public Order getOrder(Integer orderNumber);

	public List<Order> searchOrders(String cpf);

	public List<Order> searchOrdersByDeliveryManId(Integer deliveryManId);

	public void updateOrder(Order order, Integer orderNumber);
	
	public void startOrderPayment(Integer orderNumber);
	
	public void confirmOrderPayment(Integer orderNumber);

	public void startOrderDelivery(Integer orderNumber);

	public void confirmOrderDelivery(Integer orderNumber);

	public List<Order> getAllOrders();
}
