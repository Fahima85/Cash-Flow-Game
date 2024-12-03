package main.java.be.vub.cashflow.game;

import java.util.List;
import java.util.Scanner;

//TODO; Check to meet all of the requirements from Prof. Slides.
//TODO; Adding Object Oriented Features (Abstract,Interface,Inheritance,PolyMorphism,Dependency Injection)
//TODO; Adding Features from Like (Generics,Collection,lambda) etc.
//TODO; When a User Move from One Tile(Location) to Another we Have to Show Specific Message A----->B
//TODO; Grab something

public class Game {
    private List<Player> players;    // List of players in the game
    private Player currentPlayer;
    private GameBoard gameBoard;

    /**
     * @param gameBoard
     * @param players
     */
    public Game(GameBoard gameBoard, List<Player> players) {
        this.gameBoard = gameBoard;
        this.players = players;
    }

    /**
     *
     */
    public void startGame() {
        System.out.println("Starting game");
        gameBoard.fillTileList();

        System.out.println("Welcome to the game! Type 'help' for commands.");
        Scanner scanner = new Scanner(System.in);

        while (true) {
//            if (this.isGameOver()) {
//                this.endGame();
//            }
            String command = scanner.nextLine().trim();
            System.out.println("Players:");
            for (int i = 0; i < players.size(); i++) {
                System.out.println(i + 1 + ". " + players.get(i).getName());
            }
            System.out.print("Select a player (enter number): ");
            String input = scanner.nextLine().trim();
            int playerIndex = Integer.parseInt(input) - 1;

            if (playerIndex < 0 || playerIndex >= players.size()) {
                System.out.println("Invalid player selection.");
                continue;
            }

            Player currentPlayer = players.get(playerIndex);

            System.out.print(currentPlayer.getName() + " > ");
            String[] parts = command.split(" ", 2);
            String action = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : null;

            switch (action) {
                case "go":
                    if (argument != null) {
                        currentPlayer.move(argument);
                    } else {
                        System.out.println("Go where?");
                    }
                    break;
                case "look":
                    currentPlayer.look();
                    break;
                case "take":
                    if (argument != null) currentPlayer.take(argument);
                    else System.out.println("Take what?");
                    break;
                case "drop":
                    if (argument != null) currentPlayer.drop(argument);
                    else System.out.println("Drop what?");
                    break;
                case "inventory":
                    currentPlayer.inventory();
                    break;
                case "help":
                    this.help();
                    break;
                default:
                    System.out.println("Unknown command. Type 'help' for a list of commands.");
            }
        }

//        this.moveOnTiles(6);
//        while (!this.isGameOver()) {
//            this.nextTurn();
//        }

    }

    /**
     * @return boolean
     */
    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getCash() <= 0) {
                return true;
            }
        }
        return false;
    }

    public void endGame() {
        System.out.println("Game Over!");
        for (Player player : players) {
            System.out.println(player.getName() + " Final cash: " + player.getCash());
        }
        // TODO; We have to determine which player is winner;
    }

    public void moveOnTiles(int tas) {
        Tile currentTile = this.gameBoard.calculateCurrentTile(tas);
        currentPlayer.setCurrentTile(currentTile);
        // TODO; We have to do conditional check to determine if the tile is income or expense type
        // TODO; Depend on the situation we have to update asset or liabilities
        // TODO;
        currentPlayer.setIncome(currentTile.getValue());
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

    public Game(List<Player> players) {
        this.players = players;
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
