package main.java.be.vub.cashflow.accounting;

import main.java.be.vub.cashflow.game.Player;

/**
 * Represents Income that adds to the player's net worth.
 */
public class Income extends Item {

    public Income(String name, String description, double price) {
        super(name, description, price);
    }


    @Override
    public void use(Player player) {
        System.out.println("Receiving income: " + this.getName() + " worth $" + this.getPrice());
        player.setNetWorth(this.getPrice());
    }
}
