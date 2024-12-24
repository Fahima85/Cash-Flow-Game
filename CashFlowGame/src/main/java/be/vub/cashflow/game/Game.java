package main.java.be.vub.cashflow.game;

import java.util.Scanner;

public class Game {

    private Player player;    // List of players in the game
    private Player currentPlayer;
    private GameBoard gameBoard;

    private static final int TARGET_NET_WORTH = 1000;

    /**
     * @param gameBoard
     * @param players
     */
    public Game(GameBoard gameBoard, Player players) {
        this.gameBoard = gameBoard;
        this.player = players;
    }

    public Game(Player players) {
        this.player = players;
    }

    /**
     * Starts the game loop and manages player interactions.
     */
    public void startGame() {
        System.out.println("Starting game");
        System.out.println("Welcome, " + player.getName() + "! Type 'help' for commands.");
        Scanner scanner = new Scanner(System.in);

        // Initialize player's starting position if not already set
        if (!currentPlayer.hasCurrentTile()) {
            currentPlayer.setCurrentTile(this.gameBoard.getStartTile());
        }

        while (true) {
            // Check for a winner
            if (this.isGameOver()) {
                endGame();
                break;
            }

            // Display the current tile information
            Tile currentTile = player.getCurrentTile();
            System.out.println("You are currently at: " + currentTile.getName() + " (" + currentTile.getDescription() + ")");
            if (currentTile.getItem() != null) {
                System.out.println("You see: " + currentTile.getItem().getName());
            }


            // Prompt for command input
            System.out.print(player.getName() + " > ");
            String command = scanner.nextLine().trim();

            // Prompt for command input

            String[] parts = command.split(" ", 2);
            String action = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : null;

            // Process commands with Open Closed Principle eliminate [if else and switch case]
            ICommand commandToExecute = CommandPool.getCommand(action);
            commandToExecute.execute(currentPlayer, argument, this);
        }
    }

    private void dropItems(String argument) {
        if (argument != null) {
            currentPlayer.drop(argument);
        } else {
            System.out.println("Specify what you want to drop.");
        }
    }

    private void takeItems(String argument) {
        if (argument != null) {
            currentPlayer.take(argument);
        } else {
            System.out.println("Specify what you want to take.");
        }
    }

    private void goOnboard(String argument) {
        if (argument != null) {
            currentPlayer.move(argument, gameBoard);
        } else {
            System.out.println("Go where?" + "(Please specify a direction : north, south, east, west )");
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

    public void endGame() {
        System.out.println("Game Over!");
        System.out.println(player.getName() + " Final cash: " + player.getNetWorth());
        // TODO; We have to determine which player is winner;
    }

    public void buyAsset() {
        //TODO; We have to withdraw cash from player balance and deposit to the owner player balance;
        //TODO; Transaction
        //TODO; If an asset is occupied by one player , it can't buy several times;
        //TODO; Before buying any tile we have to call hasOwner method from Tile class
    }

    public void liability() {
        //TODO; We have to Update Liability for Player
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
