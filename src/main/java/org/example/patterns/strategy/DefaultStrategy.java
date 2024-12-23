package org.example.patterns.strategy;

import org.example.agentManager.Transaction;

public class DefaultStrategy implements Strategy {
    @Override
    public void execute(Transaction transaction) {
        System.out.println("Default strategy executed for transaction: " + transaction);
    }
}