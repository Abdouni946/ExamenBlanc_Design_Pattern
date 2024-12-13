package org.example.enums;

public enum TransactionType {
    VENTE(1, "Vente de bien ou service"),
    ACHAT(-1, "Achat de bien ou service");

    private final int multiplicateur;
    private final String description;

    TransactionType(int multiplicateur, String description) {
        this.multiplicateur = multiplicateur;
        this.description = description;
    }
}