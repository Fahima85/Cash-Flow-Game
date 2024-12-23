package main.java.be.vub.cashflow.accounting;

import main.java.be.vub.cashflow.game.Player;

/*
    Represents a general financial item in the game.
*/
abstract public class Item {
    private String name;
    private String description;
    private double price;

    /**
     * Constructs an Item with the given name, description and price.
     *
     * @param name        the name of the item
     * @param description the description of the item
     * @param price       the value of the item
     */
    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /**
     * Gets the name of the item.
     *
     * @return the item name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the description of the item.
     *
     * @return the item description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the price of the item.
     *
     * @return the item price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Abstract method to define how the item affects the player.
     *
     * @param player the player interacting with the item
     */
    public abstract void use(Player player);
}
