package main.java.be.vub.cashflow.game;

import java.util.Scanner;

/**
 * Main class that manages  Game.
 * It handles game setup, player actions, and game logic.
 */
public class Start {

    private static final int GRID_SIZE = 20;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Name Of Player: ");
        String playerName = scanner.nextLine();   // reads the name of player
        Player player = new Player(playerName);

        // Create a GameBoard object and pass it to the Game class
        GameBoard gameBoard = new GameBoard(GRID_SIZE);
        gameBoard.createTiles(); // Initialize the tiles
        // Pass GameBoard and players to the Game class
        Game game = new Game(gameBoard, player);
        game.startGame();// Start the game
    }
}
