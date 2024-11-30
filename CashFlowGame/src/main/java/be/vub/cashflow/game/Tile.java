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

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }
}
