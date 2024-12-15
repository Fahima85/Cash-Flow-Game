package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Expense;
import main.java.be.vub.cashflow.accounting.Income;
import main.java.be.vub.cashflow.accounting.Liability;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    List<Tile> tileList;
    private Tile[][] board;
    private Tile playerPosition;
    Tile startTile;
    Player owner;
    boolean finished = false;

    public GameBoard(int size) {
        board = new Tile[size][size];
    }

    public void fillTileList(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Tile("Tile (" + row + ", " + col + ")", "Description for Tile (" + row + ", " + col + ")");
            }
        }



        // Create Tiles
/*        Tile startTile = new Tile("Start", "The beginning of the Rat Race!");
        Tile assetTile = new Tile("Asset Tile", "You can gain an asset here.");
        Tile liabilityTile = new Tile("Liability Tile", "Watch out! You might take on a liability.");
        Tile incomeTile = new Tile("Income Tile", "Great! You earned some income.");
        Tile expenseTile = new Tile("Expense Tile", "Oh no! You have to pay an expense.");*/

/*        this.startTile = startTile;

        // Connect Tiles
        startTile.setNeighbor("north", assetTile);
        assetTile.setNeighbor("south", startTile);

        startTile.setNeighbor("east", liabilityTile);
        liabilityTile.setNeighbor("west", startTile);

        startTile.setNeighbor("south", incomeTile);
        incomeTile.setNeighbor("north", startTile);

        startTile.setNeighbor("west", expenseTile);
        expenseTile.setNeighbor("east", startTile);*/

/*        // Place Items
        assetTile.setItem(new Asset("Real Estate", "Real Estate", 2000));
        liabilityTile.setItem(new Liability("Credit Card Debt", "Credit Card Debt", 3000));
        incomeTile.setItem(new Income("Salary Bonus", "Salary Bonus", 1500));
        expenseTile.setItem(new Expense("Utility Bills", "Utility Bills", 2800));*/

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
        return this.startTile;
    }

    /**
     * @param currentTile
     */
    public void setCurrentTile(Tile currentTile) {
        this.playerPosition = currentTile;
    }

}
