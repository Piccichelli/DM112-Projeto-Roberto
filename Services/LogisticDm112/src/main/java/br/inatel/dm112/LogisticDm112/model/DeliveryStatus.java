package br.inatel.dm112.LogisticDm112.model;

import br.inatel.dm112.LogisticDm112.controller.support.PaymentException;

public class DeliveryStatus {
    public enum DELIVERY_STATUS {
        DELIVERY_STARTED, DELIVERY_CONCLUDED, WRONG_ORDER_STATUS, ORDER_NOT_FOUND
    }

    private int orderNumber;
    private int status;
    private String cpfReceiver;

    public DeliveryStatus() {
    }

    public static PaymentException createErrorStatus(String msg, int orderNumber, DELIVERY_STATUS errorStatus) {
        System.out.println(msg);
        return new PaymentException(msg + " Details: error status " + errorStatus.name()
                + " Order: " + orderNumber);
    }

    public DeliveryStatus(int status, int orderNumber) {
        super();
        this.status = status;
        this.orderNumber = orderNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOrderNumber() {return orderNumber;}

    public void setOrderNumber(int orderNumber) {this.orderNumber = orderNumber;}

    public String getCpfReceiver() {
        return cpfReceiver;
    }

    public void setCpfReceiver(String cpfReceiver) {
        this.cpfReceiver = cpfReceiver;
    }

    @Override
    public String toString() {
        return "DeliveryStatus [orderNumber=" + orderNumber + ", status=" + status + ", cpfReceiver=" + cpfReceiver+"]";
    }

}
