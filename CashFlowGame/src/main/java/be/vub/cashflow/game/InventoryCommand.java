package main.java.be.vub.cashflow.game;

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
