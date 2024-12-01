package main.java.be.vub.cashflow.game;

public class Tile {
    private String name;
    private TileType tileType;
    private double value;
    private String description;
    private Player owner;

    public Tile(String name, TileType tileType, double value, String description) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
    }

    public Tile(String name, TileType tileType, double value, String description, Player owner) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
        this.owner = owner;
    }

    public double getValue() {
        return this.value;
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
}
