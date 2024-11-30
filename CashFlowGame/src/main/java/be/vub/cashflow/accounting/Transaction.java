package main.java.be.vub.cashflow.accounting;

import main.java.be.vub.cashflow.game.Player;

public class Transaction {
    private String transactionId;     // Unique identifier for the transaction
    private TransactionType type;     // Type of transaction (Income, Expense, Purchase, etc.)
    private double amount;            // Amount of money involved in the transaction
    private String transactionDate;   // Date when the transaction occurred
    private String description;       // Description of the transaction
    private Player player;            // The player who made the transaction
    private Asset associatedAsset;    // Optional: Asset associated with the transaction (e.g., purchase)
    private Liability associatedLiability; // Optional: Liability associated with the transaction (e.g., mortgage payment)
    private double balanceAfterTransaction; // Player's balance after the transaction
}
