package main.java.be.vub.cashflow.accounting;

public class Liability {

    private String name;             // Name or description of the liability
    private double amountOwed;       // Total amount owed for the liability
    private double monthlyPayment;   // Monthly payment towards the liability
    private double interestRate;     // Optional: Interest rate on the liability
    private int duration;            // Optional: Duration of the liability (in months or years)
    private double remainingBalance; // Remaining balance on the liability
    private String dueDate;          // Optional: Due date of the payment (if applicable)
    private LiabilityType type;      // Type of liability (Mortgage, Car Loan, etc.)
    private String description;      // Optional: A description of the liability

}
