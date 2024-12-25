package main.java.be.vub.cashflow.game.command;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

public class GoCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player Can Move Direction with This Command";
    }

    @Override
    public String getName() {
        return "go";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        if (action != null) {
            player.move(action, gameBoard);
        } else {
            System.out.println("Go where?");
        }
    }
}
