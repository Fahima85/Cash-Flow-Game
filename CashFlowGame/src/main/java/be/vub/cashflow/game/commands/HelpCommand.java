package main.java.be.vub.cashflow.game.commands;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

public class HelpCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player can see available commands";
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        game.help();
    }
}
