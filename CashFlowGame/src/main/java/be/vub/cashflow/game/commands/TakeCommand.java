package main.java.be.vub.cashflow.game.commands;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

public class TakeCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player can take items from Tile";
    }

    @Override
    public String getName() {
        return "take";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        if (action != null) {
            player.take(action);
        } else {
            System.out.println("Take what?");
        }
    }
}
