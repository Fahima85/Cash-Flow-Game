package main.java.be.vub.cashflow.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Numbers Of Players: ");
//        String name = scanner.nextLine();  // Reads a full line
//        Player player2 = new Player(124, "");   // Another player

        GameBoard gameBoard = new GameBoard();
        List<Player> players = new ArrayList<>();
        int numberOfPlayers = scanner.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter Id Of Player: " + (i + 1));
            int playerId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Name Of Player: " + (i + 1));
            String playerName = scanner.nextLine();
            players.add(new Player(playerId, playerName));
        }

        Game game = new Game(gameBoard, players);
        game.startGame();


        //scanner.close();

    }
}
