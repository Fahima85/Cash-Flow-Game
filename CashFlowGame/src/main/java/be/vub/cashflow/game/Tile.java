package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a location in the game where players can interact with items.
 */
public class Tile {

    private String name;
    private TileType tileType;
    private double value;
    private String description;
    private Player owner;
    private Map<String, Tile> neighbors;
    private Item item;
    private Character character;

    /**
     * Constructs a Tile with a name and description.
     *
     * @param name        the name of the tile
     * @param description a brief description of the tile
     */
    public Tile(String name, String description) {
        this.name = name;
        this.description = description;
        this.neighbors = new HashMap<>();
    }

    /**
     * Constructs a Tile with a name, tileType,value and description.
     *
     * @param name        the name of the tile
     * @param tileType    type of the tile
     * @param value       value of the tile
     * @param description a brief description of the tile
     */
    public Tile(String name, TileType tileType, double value, String description) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
        this.neighbors = new HashMap<>();
    }

    /**
     * Constructs a Tile with a name, tileType,value,description and Owner.
     *
     * @param name        the name of the tile
     * @param tileType    type of the tile
     * @param value       value of the tile
     * @param description a brief description of the tile
     * @param owner       owner of the tile
     */
    public Tile(String name, TileType tileType, double value, String description, Player owner) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
        this.owner = owner;
        this.neighbors = new HashMap<>();
    }

    /**
     * Sets a neighboring tile in a specific direction.
     *
     * @param direction the direction of the neighbor (e.g., "north", "south")
     * @param neighbor  the neighboring tile
     */
    public void setNeighbor(String direction, Tile neighbor) {
        neighbors.put(direction.toLowerCase(), neighbor);
    }

    /**
     * Gets the neighboring tile in a specific direction.
     *
     * @param direction the direction to check
     * @return the neighboring tile or null if no tile exists
     */
    public Tile getNeighbor(String direction) {
        return neighbors.get(direction.toLowerCase());
    }

    /**
     * Gets the name of the tile
     *
     * @return the tile name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the descriotion of the tile
     *
     * @return the description of tile
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the value of the tile
     *
     * @return the value of tile
     */
    public double getValue() {
        return this.value;
    }


    /**
     * Gets if the tile has an Item
     *
     * @return boolean whether an Item exists or not
     */
    public boolean hasItem() {
        return this.item != null;
    }

    public boolean hasCharacter() {
        return this.character != null;
    }

    /**
     * Gets the item on the tile.
     *
     * @return the item on the tile or null if no item exists
     */
    public Item getItem() {
        return item;
    }

    /**
     * Set the item on the tile.
     *
     * @param item Item class instance that will place in the tile
     */

    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Removes the item from the tile when a player take this.
     */
    public void removeItem() {
        this.item = null;
    }

    /**
     * Gets the Owner of the tile.
     *
     * @return the item owner
     */
    public Player getOwner() {
        return this.owner;
    }


    /**
     * Set the item on the tile.
     *
     * @param owner Player class instance that will place as owner of the tile
     */

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * Gets the owner of the tile.
     *
     * @return the Owner of the tile or null if no item exists
     */
    public boolean hasOwner() {
        return this.owner != null;
    }

    /**
     * Gets the tileType of the tile.
     *
     * @return the tileType of the tile
     */

    public TileType getTileType() {
        return tileType;
    }

    /**
     * Set the tileType on the tile.
     *
     * @param tileType TileType enum instance that will place as tileType of the tile
     */
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
