package main.java.be.vub.cashflow.game;

public class Tile {
    String name;
    TileType tileType;
    double value;
    String description;

    public Tile(String name, TileType tileType, double value, String description) {
        this.name = name;
        this.tileType = tileType;
        this.value = value;
        this.description = description;
    }
}
