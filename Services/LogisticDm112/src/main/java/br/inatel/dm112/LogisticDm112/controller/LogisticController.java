package br.inatel.dm112.LogisticDm112.controller;

import br.inatel.dm112.LogisticDm112.interfaces.Logistic;
import br.inatel.dm112.LogisticDm112.model.DeliveryStatus;
import br.inatel.dm112.LogisticDm112.model.Order;
import br.inatel.dm112.LogisticDm112.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LogisticController implements Logistic {

    @Autowired
    private LogisticService service;

    @Override
    @GetMapping("/getOrdersOfDeliveryMan/{deliveryManId}")
    public List<Order> getOrdersOfDeliveryOfOrder(@PathVariable("deliveryManId") Integer deliveryManId) {
        System.out.println("LogisticRest - getOrdersOfDeliveryMan");
        return service.getOrdersOfDeliveryMan(deliveryManId);
    }

    @Override
    @GetMapping("/startDeliveryOfOrder/{orderNumber}")
    public DeliveryStatus startDeliveryOfOrder(
            @PathVariable("orderNumber") Integer orderNumber) {

        System.out.println("LogisticRest - startDeliveryOfOrder");
        return service.startDeliveryOfOrder(orderNumber);
    }

    @Override
    @GetMapping("/confirmDeliveryOfOrder/{cpfReceiver:.+}/{orderNumber}")
    public DeliveryStatus confirmDeliveryOfOrder(
            @PathVariable("orderNumber") Integer orderNumber,
            @PathVariable("cpfReceiver") String cpfReceiver) {

        Date date = new Date();
        System.out.println("LogisticRest - confirmDeliveryOfOrder");
        return service.confirmDeliveryOfOrder(cpfReceiver, orderNumber, date);
    }

    @GetMapping("/test")
    public String confirmDeliveryOfOrder() {

        service.emailTest();

        return "chamou";
    }

}