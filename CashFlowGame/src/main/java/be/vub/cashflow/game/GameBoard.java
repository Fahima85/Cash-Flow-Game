package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Expense;
import main.java.be.vub.cashflow.accounting.Income;
import main.java.be.vub.cashflow.accounting.Liability;
import main.java.be.vub.cashflow.game.enums.TileType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private static final int MAX_PRICE = 550;
    private static final int MIN_PRICE = 50;
    private List<Tile> tileList;
    private Tile[][] board;
    private int currentRow;
    private int currentColomn;
    private int tileGridSize;

    public GameBoard(int size) {
        this.board = new Tile[size][size];
        this.tileList = new ArrayList<>();
        this.tileGridSize = size;
    }

    /**
     * Dynamically creates a grid of tiles and assigns neighbors and items.
     * The start tile is defined as the top-left tile in the grid.
     */
    public void createTiles() {

        for (int row = 0; row < this.tileGridSize; row++) {
            for (int col = 0; col < this.tileGridSize; col++) {
                board[row][col] = new Tile("Tile (" + row + ", " + col + ")", "It means: Row number = " + row + ", Column number = " + col);
                tileList.add(board[row][col]);
            }
        }
        // Connect tiles dynamically
        this.connectTiles();

        // Assign Items to the tiles
        this.assignItemsToTiles();
    }

    /**
     * Connect Tile to another tile as Neighbor
     */
    private void connectTiles() {
        for (int rowIteration = 0; rowIteration < this.tileGridSize; rowIteration++) {
            for (int columnIteration = 0; columnIteration < this.tileGridSize; columnIteration++) {
                Tile currentTile = this.board[rowIteration][columnIteration];
                if (rowIteration > 0) {
                    currentTile.setNeighbor("north", this.board[rowIteration - 1][columnIteration]); // Connect north
                }
                if (rowIteration < this.tileGridSize - 1) {
                    currentTile.setNeighbor("south", this.board[rowIteration + 1][columnIteration]); // Connect south
                }
                if (columnIteration > 0) {
                    currentTile.setNeighbor("west", this.board[rowIteration][columnIteration - 1]); // Connect west
                }
                if (columnIteration < this.tileGridSize - 1) {
                    currentTile.setNeighbor("east", this.board[rowIteration][columnIteration + 1]); // Connect east
                }
            }
        }
    }

    /**
     * Sets the item on Tile Randomly, some Tile without any item.
     */
    private void assignItemsToTiles() {

        Random random = new Random();
        TileType[] tileTypes = TileType.values();
        Character richDady = new Character("RichDady");
        richDady.setMessage("It is a good Deal, don't lose it!");
        for (Tile tile : this.tileList) {

            if (tile == this.getStartTile()) {
                continue;
            }
            if (random.nextBoolean()) { // Randomly decide if this tile gets an item
                TileType tileType = tileTypes[random.nextInt(tileTypes.length)];
                int price = random.nextInt(MAX_PRICE - MIN_PRICE + 1) + MIN_PRICE; // Random price between 50 and 550
                switch (tileType) {
                    case ASSET:
                        tile.setItem(new Asset("Real Estate", "Real State", price));
                        tile.setCharacter(richDady);
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
        int newRow = currentRow;
        int newCol = currentColomn;
        switch (direction.toLowerCase()) {
            case "north":
                newRow--;
                break;
            case "south":
                newRow++;
                break;
            case "east":
                newCol++;
                break;
            case "west":
                newCol--;
                break;
            default:
                System.out.println("Invalid direction");
                return null;
        }
        if (newRow >= 0 && newRow < tileGridSize && newCol >= 0 && newCol < tileGridSize) {
            currentRow = newRow;
            currentColomn = newCol;
            return board[currentRow][currentColomn];
        }
        System.out.println("Movement out of bounds");
        return null;
    }

    public Tile getStartTile() {
        return this.board[0][0];
    }

    public void visualizeBoard() {
        StringBuilder boardVisualization = new StringBuilder();

        for (int row = 0; row < tileGridSize; row++) {
            for (int col = 0; col < tileGridSize; col++) {
                Tile tile = board[row][col];

                if (tile == board[currentRow][currentColomn]) {
                    // Player's position: include the item if present
                    if (tile.getItem() != null) {
                        String itemName = tile.getItem().getName().substring(0, 1); // Assuming each item has a 'getName()' method
                        boardVisualization.append("[P:").append(itemName).append("]");
                    } else {
                        boardVisualization.append("[P]");
                    }
                } else if (tile.getItem() != null) {
                    // Other tiles with items: show the first letter of the item type
                    String itemType = tile.getItem().getName().substring(0, 1); // E.g., "A" for Asset
                    boardVisualization.append("[").append(itemType).append("]");
                } else {
                    // Empty tiles
                    boardVisualization.append("[ ]");
                }
            }
            boardVisualization.append("\n"); // Move to the next row
        }

        System.out.println(boardVisualization.toString());
    }


}
