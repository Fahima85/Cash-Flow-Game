package main.java.be.vub.cashflow.game.commands;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

class LookCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player can look on Tile";
    }

    @Override
    public String getName() {
        return "look";
    }

    @Override
    public void execute(Player player, String argument, Game game, GameBoard gameBoard) {
        player.look();
    }
}
