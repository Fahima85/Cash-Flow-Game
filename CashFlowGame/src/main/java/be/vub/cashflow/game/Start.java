package main.java.be.vub.cashflow.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Numbers Of Players: ");

        List<Player> players = new ArrayList<>();
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();  // Clear the newline left by nextInt()

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter Name Of Player: " );
            String playerName = scanner.nextLine();   // Now this correctly reads the name
            players.add(new Player(playerName));
        }
        // Create a GameBoard object and pass it to the Game class
        GameBoard gameBoard = new GameBoard();
        gameBoard.fillTileList(); // Initialize the tiles
        // Pass GameBoard and players to the Game class
        Game game = new Game(gameBoard, players);
        game.startGame();// Start the game
    }
}
