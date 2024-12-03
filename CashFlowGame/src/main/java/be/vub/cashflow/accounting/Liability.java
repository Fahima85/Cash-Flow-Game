package main.java.be.vub.cashflow.accounting;

public class Liability extends Item {


    private String name;             // Name or description of the liability
    private double amountOwed;       // Total amount owed for the liability
    private double monthlyPayment;   // Monthly payment towards the liability
    private double interestRate;     // Optional: Interest rate on the liability
    private int duration;            // Optional: Duration of the liability (in months or years)
    private double remainingBalance; // Remaining balance on the liability
    private String dueDate;          // Optional: Due date of the payment (if applicable)
    private LiabilityType type;      // Type of liability (Mortgage, Car Loan, etc.)
    private String description;

    public Liability(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public void use() {
        System.out.println("Using the liability: " + this.getName());
    }
}
