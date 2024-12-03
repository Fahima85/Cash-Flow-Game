package main.java.be.vub.cashflow.accounting;

public class Income extends Item {
    private String source;             // The source of the income (e.g., Salary, Investment)
    private double amount;             // Amount of income
    private IncomeFrequency frequency;

    public Income(String name, String description, double price) {
        super(name, description, price);
    }


    @Override
    public void use() {

    }
}
