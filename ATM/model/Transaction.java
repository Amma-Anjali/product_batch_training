package model;

import enums.TransactionType;

public class Transaction {

    private String transactionId;
    private TransactionType type;
    private double amount;

    public Transaction(
            String transactionId,
            TransactionType type,
            double amount) {

        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public void display() {

        System.out.println(
                transactionId + " | " +
                type + " | ₹" +
                amount
        );
    }
}