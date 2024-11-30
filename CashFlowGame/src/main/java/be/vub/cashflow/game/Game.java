package main.java.be.vub.cashflow.game;

import java.util.List;

public class Game {
    private List<Player> players;    // List of players in the game
    private Player currentPlayer;
    private GameBoard gameBoard;

    public Game(GameBoard gameBoard, List<Player> players) {
        this.gameBoard = gameBoard;
        this.players = players;
    }

    public void startGame() {
        System.out.println("Starting game");
        gameBoard.fillTileList();
        while (!this.isGameOver()) {
            this.nextTurn();
        }
        this.endGame();
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getCash() <= 0) {
                return true;
            }
        }
        return false;
    }

    public void nextTurn() {
        Player currentPlayer = this.currentPlayer;
        System.out.println("Turn For: " + currentPlayer.name);
        Tile tile = currentPlayer.getCurrentTile();
        System.out.println("Player landed on tile at position " + currentPlayer.getCurrentTile());
//        tile.applyEffect(currentPlayer);
//        System.out.println("Cash after effect: " + currentPlayer.getCash());
//        System.out.println("Cash Flow: " + currentPlayer.calculateCashFlow());

    }

    public void endGame() {
        System.out.println("Game Over!");
        for (Player player : players) {
            System.out.println(player.getName() + " Final cash: " + player.getCash());
        }
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
