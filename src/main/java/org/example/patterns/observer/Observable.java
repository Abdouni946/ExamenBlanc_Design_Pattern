package org.example.patterns.observer;

import org.example.agentManager.Transaction;

import javax.management.Notification;


public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Transaction transaction);
}