package main.java.be.vub.cashflow.game.commands;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

public class InventoryCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player can view his inventory";
    }

    @Override
    public String getName() {
        return "inventory";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        player.inventory();
    }
}
