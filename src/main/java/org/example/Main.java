package org.example;

import org.example.agentManager.Transaction;
import org.example.enums.TransactionType;

import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction.Builder()
                .id("1")
                .date(LocalDateTime.now())
                .montant(1500)
                .type(TransactionType.VENTE)
                .build();

        // Affichage des détails de la transaction
        System.out.println("Transaction créée avec succès :");
        System.out.println("ID : " + transaction.getId());
        System.out.println("Date : " + transaction.getDate());
        System.out.println("Montant : " + transaction.getMontant());
        System.out.println("Type : " + transaction.getType());
        }
}
