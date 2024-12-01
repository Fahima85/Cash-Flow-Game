package main.java.be.vub.cashflow.accounting;

public class Expense {
    private ExpenseType expenseType;
    private double amount;
    private String description;
    private String dueDate;

    /**
     *
     * @param expenseType
     * @param amount
     * @param description
     * @param dueDate
     */
    public Expense(ExpenseType expenseType, double amount, String description, String dueDate) {
        this.expenseType = expenseType;
        this.amount = amount;
        this.description = description;
        this.dueDate = dueDate;
    }
}
