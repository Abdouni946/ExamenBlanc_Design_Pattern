package org.example.patterns.observer;

import org.example.agentManager.Transaction;

public interface Observer {
    void update(String agentName, Transaction transaction);
}