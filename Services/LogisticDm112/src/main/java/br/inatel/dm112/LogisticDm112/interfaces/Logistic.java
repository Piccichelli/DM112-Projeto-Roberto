package br.inatel.dm112.LogisticDm112.interfaces;

import br.inatel.dm112.LogisticDm112.model.DeliveryStatus;
import br.inatel.dm112.LogisticDm112.model.Order;

import java.util.List;


public interface Logistic {
    List<Order> getOrdersOfDeliveryOfOrder(Integer deliveryManId);
    DeliveryStatus startDeliveryOfOrder(Integer orderId);
    DeliveryStatus confirmDeliveryOfOrder(Integer orderId, String cpfReceiver);
}
