package br.inatel.dm112.LogisticDm112.model;

public class MailRequestData {

    private int orderNumber;
    private String to;
    private String content;

    public MailRequestData() {
    }

    public MailRequestData(int orderNumber, String to, String content) {
        this.orderNumber = orderNumber;
        this.to = to;
        this.content = content;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MailRequestData [orderNumber=" + orderNumber + ", to=" + to + "]";
    }

}
