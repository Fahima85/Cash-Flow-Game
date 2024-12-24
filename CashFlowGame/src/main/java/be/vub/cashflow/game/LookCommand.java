package main.java.be.vub.cashflow.game;

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
