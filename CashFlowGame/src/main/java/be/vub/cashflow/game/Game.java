package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.game.command.CommandPool;
import main.java.be.vub.cashflow.game.command.ICommand;

import java.util.Scanner;

public class Game {

    private Player player;    // player instance
    private Player currentPlayer;
    private GameBoard gameBoard;

    private static final int TARGET_NET_WORTH = 1000;

    /**
     * @param gameBoard the game board object
     * @param player    the player object
     */
    public Game(GameBoard gameBoard, Player player) {
        this.gameBoard = gameBoard;
        this.player = player;
    }

    public Game(Player player) {
        this.player = player;
    }

    /**
     * Starts the game loop and manages player interactions.
     */
    public void startGame() {
        System.out.println("Starting game");
        System.out.println("Welcome, " + player.getName() + "! Type 'help' for commands.");
        Scanner scanner = new Scanner(System.in);

        // Initialize player's starting position if not already set
        if (!player.hasCurrentTile()) {
            player.setCurrentTile(this.gameBoard.getStartTile());
        }

        while (true) {
            // Check for a winner
            if (this.isGameOver()) {
                break;
            }
            // Display the current tile information
            Tile currentTile = player.getCurrentTile();
            // Prompt for command input
            System.out.print(player.getName() + " > ");
            String command = scanner.nextLine().trim();

            // Prompt for command input
            String[] parts = command.split(" ", 2);
            String action = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : null;
            // Process commands with Open Closed Principle eliminate [if else and switch case]
            ICommand commandToExecute = CommandPool.getCommand(action);
            commandToExecute.execute(player, argument, this, this.gameBoard);
        }
    }

    /**
     * Gets the Winner player who achieved target net worth
     *
     * @return boolean
     */
    private boolean isGameOver() {
        if (player.getNetWorth() >= TARGET_NET_WORTH) {
            System.out.println(player.getName() + " has achieved the target net worth and wins!");
            return true;
        }
        return false;
    }

    public void help() {
        System.out.println("Available commands:");
        System.out.println("- go [north/east/south/west]");
        System.out.println("- look");
        System.out.println("- inventory");
        System.out.println("- take [item_name]");
        System.out.println("- drop [item_name]");
        System.out.println("- help");
    }

}
