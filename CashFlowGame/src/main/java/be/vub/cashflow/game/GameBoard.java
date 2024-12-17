package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Expense;
import main.java.be.vub.cashflow.accounting.Income;
import main.java.be.vub.cashflow.accounting.Liability;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private List<Tile> tileList;
    private Tile[][] board;
    private Tile playerPosition;
    Player owner;
    boolean finished = false;

    public GameBoard(int size) {
        this.board = new Tile[size][size];
        this.tileList = new ArrayList<>();
    }

    public void fillTileList(int size) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Tile("Tile (" + row + ", " + col + ")", "Description for Tile (" + row + ", " + col + ")");
                tileList.add(board[row][col]);
            }
        }
        // Connect tiles dynamically
        this.connectTiles(size);

        // Assign Items to the tiles
        this.assignItemsToTiles();

    }

    private void connectTiles(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Tile currentTile = this.board[i][j];
                if (i > 0) {
                    currentTile.setNeighbor("north", this.board[i - 1][j]); // Connect north
                }
                if (i < size - 1) {
                    currentTile.setNeighbor("south", this.board[i + 1][j]); // Connect south
                }
                if (j > 0) {
                    currentTile.setNeighbor("west", this.board[i][j - 1]); // Connect west
                }
                if (j < size - 1) {
                    currentTile.setNeighbor("east", this.board[i][j + 1]); // Connect east
                }
            }
        }
    }

    private void assignItemsToTiles() {

        Random random = new Random();
        TileType[] tileTypes = TileType.values();
        for (Tile tile : this.tileList) {

            if (tile == this.getStartTile()) {
                continue;
            }

            if (random.nextBoolean()) { // Randomly decide if this tile gets an item
                TileType tileType = tileTypes[random.nextInt(tileTypes.length)];
                int price = random.nextInt(500) + 50; // Random price between 50 and 550
                switch (tileType) {
                    case ASSET:
                        tile.setItem(new Asset("Real Estate", "Real State", price));
                        break;
                    case LIABILITY:
                        tile.setItem(new Liability("Credit Card Debt", "Credit Card Debt", price));
                        break;
                    case EXPENSE:
                        tile.setItem(new Expense("Utility Bills", "Utility Bills", price));
                        break;
                    case INCOME:
                        tile.setItem(new Income("Salary Bonus", "Salary Bonus", price));
                        break;
                }
            }
        }
    }

    /**
     * @param move
     * @return Tile
     */
    public Tile calculateCurrentTile(int move) {
        int tileIndex = move % tileList.size();
        Tile tile = tileList.get(tileIndex);
        playerPosition = tile;
        return tile;
    }

    public Tile getCurrentTile() {
        return playerPosition;
    }

    public Tile getStartTile() {
        return this.board[0][0];
    }

    /**
     * @param currentTile
     */
    public void setCurrentTile(Tile currentTile) {
        this.playerPosition = currentTile;
    }

}
