package org.example;

import org.example.agentManager.Agent;
import org.example.agentManager.Transaction;
import org.example.enums.TransactionType;
import org.example.patterns.observer.ScoringStrategy;

import java.time.LocalDateTime;
import java.util.Date;

import static org.example.enums.TransactionType.ACHAT;
import static org.example.enums.TransactionType.VENTE;


public class Main {
    public static void main(String[] args) {
            Agent agent = new Agent("Agent");

            Transaction t1 = new Transaction.Builder()
                    .id("01")
                    .date(new Date())
                    .montant(100.0)
                    .type(TransactionType.VENTE)
                    .build();

            Transaction t2 = new Transaction.Builder()
                    .id("02")
                    .date(new Date())
                    .montant(50.0)
                    .type(TransactionType.ACHAT)
                    .build();

            Transaction t3 = new Transaction.Builder()
                    .id("03")
                    .date(new Date())
                    .montant(200.0)
                    .type(TransactionType.VENTE)
                    .build();


            agent.addTransaction(t1);
            agent.addTransaction(t2);
            agent.addTransaction(t3);

            System.out.println("All Transactions: " + agent.getTransactions());

            System.out.println("Vente Transactions: " + agent.getVenteTransactions());

            System.out.println("Max Transaction: " + agent.getMaxTransaction());
        }
}
