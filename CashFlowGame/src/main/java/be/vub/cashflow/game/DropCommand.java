package main.java.be.vub.cashflow.game;

public class DropCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player can drop an item on Tile";
    }

    @Override
    public String getName() {
        return "drop";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        if (action != null) {
            player.drop(action);
        } else {
            System.out.println("Drop what?");
        }
    }
}
