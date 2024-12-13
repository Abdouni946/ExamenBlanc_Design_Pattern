package org.example.agentManager;

import org.example.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private String id;
    private java.util.Date date;
    private double montant;
    private TransactionType type;

    //private AgentRef sourceAgent;

    // Builder
    public static class Builder {
        private Transaction transaction;

        public Builder() {
            transaction = new Transaction();
        }

        public Builder id(String id) {
            transaction.id = id;
            return this;
        }

        public Builder date(Date date) {
            transaction.date = date;
            return this;
        }

        public Builder type(TransactionType type) {
            transaction.type = type;
            return this;
        }

        public Builder montant(double montant) {
            transaction.montant = montant;
            return this;
        }

        public Transaction build() {
            return transaction;
        }

    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + montant +
                ", type=" + type +
                '}';
    }

}
