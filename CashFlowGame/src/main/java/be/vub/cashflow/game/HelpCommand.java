package main.java.be.vub.cashflow.game;

public class HelpCommand implements ICommand {
    @Override
    public String getDescription() {
        return "Player can see available commands";
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(Player player, String action, Game game) {
        game.help();
    }
}
