package org.example.patterns.strategy;

import org.example.agentManager.Transaction;
import org.example.enums.TransactionType;

public class ScoringStrategy implements Strategy {
    private double score = 0;

    @Override
    public void execute(Transaction transaction) {
        if (transaction.getType() == TransactionType.VENTE) {
            score += transaction.getMontant();
        } else if (transaction.getType() == TransactionType.ACHAT) {
            score -= transaction.getMontant();
        }
        System.out.println("Updated score: " + score);
    }
}