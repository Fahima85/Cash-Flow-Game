package main.java.be.vub.cashflow.accounting;

public class Expense extends Item {

    public Expense(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public void use() {
        System.out.println("Using the expense: " + this.getName());
    }
}
