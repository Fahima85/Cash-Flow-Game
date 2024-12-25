package main.java.be.vub.cashflow.game.commands;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

public class UnknownCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Unknown command";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        System.out.println("Unknown command. Type 'help' for a list of commands.");
    }
}
