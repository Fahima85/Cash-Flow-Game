package main.java.be.vub.cashflow.accounting;

import main.java.be.vub.cashflow.game.Player;

/**
 * Represents an Asset that increases the player's net worth.
 */
public class Asset extends Item {

    /**
     * @param name
     * @param description
     * @param price
     */
    public Asset(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public void use(Player player) {
        System.out.println("Acquiring asset: " + this.getName() + " worth $" + this.getPrice());
        player.setNetWorth(getPrice());
    }
}
