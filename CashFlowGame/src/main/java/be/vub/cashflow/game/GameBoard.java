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
    private int currentRow;
    private int currentCol;
    Player owner;
    boolean finished = false;
    private int tileGridSize;

    public GameBoard(int size) {
        this.board = new Tile[size][size];
        this.tileList = new ArrayList<>();
        this.tileGridSize = size;
    }

    public void fillTileList() {

        for (int row = 0; row < this.tileGridSize; row++) {
            for (int col = 0; col < this.tileGridSize; col++) {
                board[row][col] = new Tile("Tile (" + row + ", " + col + ")", "Description for Tile (" + row + ", " + col + ")");
                tileList.add(board[row][col]);
            }
        }
        // Connect tiles dynamically
        this.connectTiles();

        // Assign Items to the tiles
        this.assignItemsToTiles();
    }

    private void connectTiles() {
        for (int row = 0; row < this.tileGridSize; row++) {
            for (int column = 0; column < this.tileGridSize; column++) {
                Tile currentTile = this.board[row][column];
                if (row > 0) {
                    currentTile.setNeighbor("north", this.board[row - 1][column]); // Connect north
                }
                if (row < this.tileGridSize - 1) {
                    currentTile.setNeighbor("south", this.board[row + 1][column]); // Connect south
                }
                if (column > 0) {
                    currentTile.setNeighbor("west", this.board[row][column - 1]); // Connect west
                }
                if (column < this.tileGridSize - 1) {
                    currentTile.setNeighbor("east", this.board[row][column + 1]); // Connect east
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
     * @param direction
     * @return Tile
     */

    public Tile calculateCurrentTile(String direction) {
        if (direction.equals("north") && this.currentRow + 1 < this.tileGridSize && this.currentRow + 1 >= 0) {
            this.currentRow += 1;
            return board[currentRow][currentCol];
        }
        if (direction.equals("south") && currentRow -1 < this.tileGridSize && currentRow - 1 >= 0) {
            this.currentRow -= 1;
            return board[currentRow][currentCol];
        }
        if (direction.equals("east") && currentCol + 1 < this.tileGridSize && currentCol + 1 >= 0) {
            this.currentCol += 1;
            return board[currentRow][currentCol];
        }
        if (direction.equals("west") && currentCol - 1 < this.tileGridSize && currentCol - 1 >= 0) {
            this.currentCol -= 1;
            return board[currentRow][currentCol];
        }
        else {
            System.out.println("Invalid direction");
            return null;
        }
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
