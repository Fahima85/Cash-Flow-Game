package main.java.be.vub.cashflow.game;

public class UnknownCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Unknown command";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void execute(Player player, String action, Game game, GameBoard gameBoard) {
        System.out.println("Unknown command. Type 'help' for a list of commands.");
    }
}
