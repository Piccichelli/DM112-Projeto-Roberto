package br.inatel.dm112.LogisticDm112.service;

import br.inatel.dm112.LogisticDm112.model.DeliveryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.dm112.LogisticDm112.client.EmailClient;
import br.inatel.dm112.LogisticDm112.client.OrderClient;
import br.inatel.dm112.LogisticDm112.model.Order;
import br.inatel.dm112.LogisticDm112.model.DeliveryStatus.DELIVERY_STATUS;

import java.util.Date;
import java.util.List;


@Service
public class LogisticService {

    @Autowired
    private OrderClient clientOrder;

    @Autowired
    private EmailClient clientEmail;

    /**
     * Lógica de geração de pendência de pagamento (1) consulta o pedido pelo número
     * (2) atualiza o status do pedido (3) gera o boleto (4) envia email com o pdf
     * (5) retorna sucesso
     *
     * @param orderNumber
     * @return
     */
    public DeliveryStatus startDeliveryOfOrder(int orderNumber) {

        Order order = getOrder(orderNumber); // (1) consulta o pedido pelo número
        clientOrder.startOrderDelivery(orderNumber);

        return new DeliveryStatus(DELIVERY_STATUS.DELIVERY_STARTED.ordinal(), orderNumber); // (5) retorna sucesso
    }

    /**
     * Lógica de confirmação de pagamento (1) consulta o pedido pelo número (2)
     * atualiza o status do pedido confirmando o pagamento (3) responde Ok
     *
     * @param cpfReceiver
     * @param orderNumber
     * @return
     */
    public DeliveryStatus confirmDeliveryOfOrder(String cpfReceiver, int orderNumber, Date date) {

        Order order = getOrder(orderNumber); // (1) consulta o pedido pelo número
        clientOrder.confirmOrderDelivery(orderNumber);
        DeliveryStatus deliveryStatus = new DeliveryStatus(DELIVERY_STATUS.DELIVERY_CONCLUDED.ordinal(), orderNumber);
        deliveryStatus.setCpfReceiver(cpfReceiver);

        clientEmail.callSendMailService(orderNumber, "Pedido entregue com sucesso");

        return deliveryStatus;
    }

    public void emailTest() {
        clientEmail.callSendMailService(1, "Pedido entregue com sucesso");
    }

    public List<Order> getOrdersOfDeliveryMan(Integer deliveryManId) {
        List<Order> orders;
        orders = clientOrder.getOrdersByDeliveryManId(deliveryManId);
        return orders;
    }

    private Order getOrder(int orderNumber) {
        if (orderNumber < 0) {
            throw DeliveryStatus.createErrorStatus("Order não pode ser negativo", orderNumber,
                    DELIVERY_STATUS.WRONG_ORDER_STATUS);
        }
        Order order;
        try {
            order = clientOrder.retrieveOrder(orderNumber); // (1) consulta o pedido pelo número
        } catch (Exception e) {
            String msg = "Pedido " + orderNumber + " não encontrado.";
            throw DeliveryStatus.createErrorStatus(msg, orderNumber, DELIVERY_STATUS.ORDER_NOT_FOUND);
        }
        return order;
    }



}