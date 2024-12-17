package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Item;

import java.util.HashMap;
import java.util.Map;

public class Tile {
    private String name;
    private TileType tileType;
    private double value;
    private String description;
    private Player owner;
    private Map<String, Tile> neighbors;
    private Item item;

    public Tile(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new HashMap<>();
    }

    public Tile(String name, TileType tileType, double value, String description) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
        this.neighbors = new HashMap<>();
    }

    public Tile(String name, TileType tileType, double value, String description, Player owner) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
        this.owner = owner;
        this.neighbors = new HashMap<>();
    }

    public void setNeighbor(String direction, Tile neighbor) {
        neighbors.put(direction.toLowerCase(), neighbor);
    }

    public Tile getNeighbor(String direction) {
        return neighbors.get(direction.toLowerCase());
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getValue() {
        return this.value;
    }


    public boolean hasItem() {
        return this.item != null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void removeItem() {
        this.item = null;
    }

    public Player getOwner() {
        return this.owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean hasOwner() {
        return this.owner != null;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public void interact(Player player) {
        if (this.item != null) {
            System.out.println("You encountered a financial scenario: " + this.item.getName());
            this.item.use();
            player.take(item.getName());
            this.removeItem();
        } else {
            System.out.println("Nothing significant happens here.");
        }
    }
}
