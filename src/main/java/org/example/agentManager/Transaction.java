package org.example.agentManager;

import org.example.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private LocalDateTime date;
    private double montant;
    private TransactionType type;
  //  private AgentRef sourceAgent;

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

        public Builder date(LocalDateTime date) {
            transaction.date = date;
            return this;
        }

        public Builder date(double montant) {
            transaction.montant = montant;
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

    public LocalDateTime getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public TransactionType getType() {
        return type;
    }


}
