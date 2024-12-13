package org.example.agentManager;

import org.example.agentManager.Transaction;
import org.example.enums.TransactionType;
import org.example.patterns.observer.DefaultStrategy;
import org.example.patterns.observer.Observable;
import org.example.patterns.observer.Observer;
import org.example.patterns.observer.Strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Agent implements Observer, Observable {
    private final String name;
    private final List<Transaction> transactions;
    private final List<Observer> observers;
    private Strategy strategy;

    public Agent(String name) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.strategy = new DefaultStrategy();
    }

    public String getName() {
        return name;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Transaction transaction) {
        for (Observer observer : observers) {
            observer.update(this.name, transaction);
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(Transaction transaction) {
        strategy.execute(transaction);
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions); // Retourne une copie pour éviter la modification externe
    }

    public List<Transaction> getVenteTransactions() {
        List<Transaction> venteTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (TransactionType.VENTE.equals(transaction.getType())) {
                venteTransactions.add(transaction);
            }
        }
        return venteTransactions;
    }

    public Transaction getMaxTransaction() {
        return transactions.stream().max(Comparator.comparing(Transaction::getMontant)).orElse(null);
    }

    @Override
    public void update(String agentName, Transaction transaction) {
        System.out.println("Notification received from " + agentName + ": " + transaction);
        executeStrategy(transaction);
    }
}
