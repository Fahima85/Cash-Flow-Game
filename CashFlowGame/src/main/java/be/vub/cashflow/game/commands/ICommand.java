package main.java.be.vub.cashflow.game.commands;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;

public interface ICommand {
    public String getDescription();

    public String getName();

    public void execute(Player player, String action, Game game, GameBoard gameBoard);
}
