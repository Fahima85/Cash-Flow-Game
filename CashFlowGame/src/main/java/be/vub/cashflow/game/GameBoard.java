package main.java.be.vub.cashflow.game;

import java.util.List;

public class GameBoard {
  List<Tile> tileList;
  Tile currentTile;
  List<Player> players;
  Player activePlayer;
  boolean finished = false;


    private void fillTileList() {
        // Creating and adding tiles to the tileList
        tileList.add(new Tile("Start", TileType.INVESTMENT, 1000, "Start your financial journey here"));
        tileList.add(new Tile("Investment Opportunity", TileType.INVESTMENT, 2000, "Invest in the stock market"));
        tileList.add(new Tile("Expense", TileType.INVESTMENT, 1000, "Pay your taxes for the year"));
        tileList.add(new Tile("Random Event", TileType.INVESTMENT, 1000, "You receive a random bonus"));
        tileList.add(new Tile("Opportunity", TileType.INVESTMENT, 1000, "Buy a real estate asset"));
        tileList.add(new Tile("Debt", TileType.INVESTMENT, 1000, "Pay off your mortgage"));
        // Add more tiles as needed
    }

}
