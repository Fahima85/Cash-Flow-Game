package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Item;
import main.java.be.vub.cashflow.accounting.Liability;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static int counter = 0;
    private int palyerId;
    private String name;
    private double income;
    private double expens;
    private Tile currentTile;
    private List<Item> inventory;

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

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income += income;
    }

    public double getExpens() {
        return expens;
    }

    public void setExpens(double expens) {
        this.expens += expens;
    }

    public void move(String direction) {
        Tile nextTile = this.currentTile.getNeighbor(direction);
        if (nextTile != null) {
            this.currentTile = nextTile;
            System.out.println(name + " moved to " + this.currentTile.getName() + ".");
            //this.currentTile.interact(this);
        } else {
            System.out.println(name + " can't go that way!");
        }
    }

    public void look() {
        System.out.println(name + " is at " + this.currentTile.getName() + ": " + this.currentTile.getDescription());
        if (this.currentTile.hasItem()) {
            System.out.println("You see a " + this.currentTile.getItem().getName() + " here.");
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
            this.currentTile.removeItem();
            System.out.println("You took the " + itemName + ".");
        } else {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    public void drop(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getName().equalsIgnoreCase(itemName)) {
                inventory.remove(i);
                this.currentTile.setItem(item);
                System.out.println("You dropped the " + itemName + ".");
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
                System.out.println("- " + item.getName());
            }
        }
    }

    public double getCash() {
        return this.getIncome() - this.getExpens();
    }
}
