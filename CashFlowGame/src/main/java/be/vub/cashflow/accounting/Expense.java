package main.java.be.vub.cashflow.accounting;

import main.java.be.vub.cashflow.game.Player;

public class Expense extends Item {

    public Expense(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public void use(Player player) {
        System.out.println("Paying expense: " + this.getName() + " costing $" + this.getPrice());
        player.setNetWorth(-this.getPrice());
    }
}
