package org.example.patterns.strategy;

import org.example.agentManager.Transaction;

public interface Strategy {
    void execute(Transaction transaction);
}