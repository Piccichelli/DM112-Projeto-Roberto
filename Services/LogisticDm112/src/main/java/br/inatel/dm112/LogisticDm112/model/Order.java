package br.inatel.dm112.LogisticDm112.model;

import java.util.Date;

public class Order {

    //	@JsonIgnore
    public static enum STATUS { FILLED, PENDING, CONFIRMED, DELIVERED }

    private int number;

    private String cpf;

    private float value;

    private int status;

    private int deliveryManID;

    //	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date orderDate;

    private Date issueDate;

    private Date paymentDate;

    public Order() {
    }

    public Order(int number, String cpf, float value, int status, Date orderDate, Date issueDate, Date paymentDate, int deliveryManID) {
        super();
        this.number = number;
        this.cpf = cpf;
        this.value = value;
        this.status = status;
        this.orderDate = orderDate;
        this.issueDate = issueDate;
        this.paymentDate = paymentDate;
        this.deliveryManID = deliveryManID;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDeliveryManID() {
        return deliveryManID;
    }

    public void setDeliveryManID(int deliveryManID) {
        this.deliveryManID = deliveryManID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Order [number=" + number + ", cpf=" + cpf + ", value=" + value + ", status=" + status + ", deliveryManId=" + deliveryManID + ", orderDate="
                + orderDate + ", issueDate=" + issueDate + ", paymentDate=" + paymentDate + "]";
    }

}
