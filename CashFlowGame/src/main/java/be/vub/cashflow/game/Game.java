package main.java.be.vub.cashflow.game;

import java.util.List;

public class Game {
    private List<Player> players;    // List of players in the game
    private Player currentPlayer;
    private GameBoard gameBoard;

    public Game(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void moveOnTiles(int tas) {
        Tile currentTile = this.gameBoard.calculateCurrentTile(tas);
        currentPlayer.setCurrentTile(currentTile);
        currentPlayer.setIncome(currentTile.value);
    }

    public Game(List<Player> players) {
        this.players = players;
    }

}
