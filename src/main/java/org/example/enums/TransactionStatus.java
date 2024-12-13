package org.example.enums;

public enum TransactionStatus {
    INITIALE("Transaction créée"),
    VALIDEE("Transaction confirmée"),
    REJETEE("Transaction annulée"),
    REMBOURSEE("Transaction remboursée");

    private final String libelle;

    TransactionStatus(String libelle) {
        this.libelle = libelle;
    }
}