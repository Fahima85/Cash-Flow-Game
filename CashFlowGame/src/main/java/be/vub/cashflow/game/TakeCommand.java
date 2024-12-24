package main.java.be.vub.cashflow.game;

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
