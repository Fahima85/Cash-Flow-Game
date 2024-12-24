package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Income;
import main.java.be.vub.cashflow.accounting.Item;
import main.java.be.vub.cashflow.accounting.Liability;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the game who can move, interact, and manage inventory.
 */
public class Player {

    private static int counter = 0;
    private int palyerId;
    private String name;
    private Tile currentTile;
    private List<Item> inventory;
    private double netWorth;

    /**
     * Constructs a Player with a name
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.palyerId = ++counter;
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    /**
     * Gets the name of the player
     *
     * @return the player name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the player current tile Position
     *
     * @return Tile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }

    /**
     * Gets true or false whether the player a current tile
     *
     * @return if the player has current tile
     */
    public boolean hasCurrentTile() {
        return this.currentTile != null;
    }

    /**
     * Set the currentTile of the player.
     *
     * @param currentTile Tile class instance that will place as currentTile of the player
     */
    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    /**
     * Allows the player to move in a specified direction.
     *
     * @param direction the direction to move (e.g., "north", "south")
     */
    // TODO; We have to do conditional check to determine if the tile is income or expense type
    // TODO; Depend on the situation we have to update asset or liabilities
    public void move(String direction, GameBoard gameBoard) {
        Tile newTile = gameBoard.calculateCurrentTile(direction);
//        Tile newTile = this.currentTile.getNeighbor(direction);
        if (newTile != null) {
            System.out.println("Moved from " + (currentTile != null ? currentTile.getName() : "start") +
                    " to " + newTile.getName());
            this.setCurrentTile(newTile); // Update player's location
        } else {
            System.out.println("You can't move in that direction.");
        }
        //currentPlayer.setNetWorth(currentTile.getValue());
    }

    /**
     * Displays the details of the current tile and available directions.
     */
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

    /**
     * Displays available directions according to current tile.
     */
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

    /**
     * Allows a player to take the Item on current tile
     *
     * @param itemName the name of the item to take
     */
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

    /**
     * Drops an item from the player's inventory onto the current tile.
     *
     * @param itemName the name of the item to drop
     */
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


    /**
     * Displays the player's inventory.
     */
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

    /**
     * Gets the Net worth of a player
     *
     * @return the net worth of player
     */
    public double getNetWorth() {
        return this.netWorth;
    }

    /**
     * Set the net worth of a player it could be addition or subtraction
     *
     * @param amount the amount to added to net worth
     */
    public void setNetWorth(double amount) {
        this.netWorth += amount;
    }
}
