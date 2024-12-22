package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Income;
import main.java.be.vub.cashflow.accounting.Item;
import main.java.be.vub.cashflow.accounting.Liability;

import java.util.ArrayList;
import java.util.List;

public class Player implements IPlayable {
    private static int counter = 0;
    private int palyerId;
    private String name;
    private Tile currentTile;
    private List<Item> inventory;
    private double netWorth;

    /**
     * @param name
     */
    public Player(String name) {
        this.palyerId = ++counter;
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return Tile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }

    public boolean hasCurrentTile() {
        return this.currentTile != null;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public void move(String direction) {
        Tile nextTile = this.currentTile.getNeighbor(direction);
        if (nextTile != null) {
            this.currentTile = nextTile;
            System.out.println(name + " moved to " + this.currentTile.getName() + ".");
        } else {
            System.out.println(name + " can't go that way!");
        }
    }

    public void look() {
        System.out.println(name + " is at " + this.currentTile.getName() + ": " + this.currentTile.getDescription());
        if (this.currentTile.hasItem()) {
            System.out.println("You see a " + this.currentTile.getItem().getName() + " here. " + "Net Worth Is $" + this.currentTile.getItem().getPrice());
        } else {
            System.out.println("No Item in this tile.");
        }
        // show connected neighbours
        this.showNeighborsOfCurrentTile(this.currentTile);
    }

    private void showNeighborsOfCurrentTile(Tile tile) {
        System.out.println("You can move in the following directions:");
        if (tile.getNeighbor("north") != null) {
            System.out.println("- North: " + tile.getNeighbor("north").getName());
        }
        if (tile.getNeighbor("south") != null) {
            System.out.println("- South: " + tile.getNeighbor("south").getName());
        }
        if (tile.getNeighbor("east") != null) {
            System.out.println("- East: " + tile.getNeighbor("east").getName());
        }
        if (tile.getNeighbor("west") != null) {
            System.out.println("- West: " + tile.getNeighbor("west").getName());
        }
    }

    public void take(String itemName) {
        Item item = this.currentTile.getItem();
        if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            inventory.add(item);
            item.use(this);
            this.currentTile.removeItem();
            System.out.println("You took the " + itemName + ".");
            System.out.println(this.getName() + "'s net worth is now $" + this.getNetWorth());
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    public void drop(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                if (this.currentTile.getItem() == null) {
                    inventory.remove(i);
                    this.currentTile.setItem(item); // Tile is empty, place the item
                    System.out.println("You dropped the " + itemName + ".");
                    if (item instanceof Asset || item instanceof Income) {
                        this.setNetWorth(-item.getPrice()); // Subtract amount from net worth
                    } else {
                        this.setNetWorth(item.getPrice()); // Add amount to net worth
                    }
                    System.out.println(this.getName() + "'s net worth is now $" + this.getNetWorth());
                } else {
                    System.out.println("The current tile already has an item. You cannot drop the " + itemName + " here.");
                }

                return;
            }
        }
        System.out.println("You don't have a " + itemName + ".");
    }


    public void inventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Your inventory contains:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getPrice());
            }
        }
    }

    public double getNetWorth() {
        return this.netWorth;
    }

    public void setNetWorth(double amount) {
        this.netWorth += amount;
    }
}
