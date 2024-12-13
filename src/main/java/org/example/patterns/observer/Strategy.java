package org.example.patterns.observer;

import org.example.agentManager.Transaction;

public interface Strategy {
    void execute(Transaction transaction);
}