package main.java.be.vub.cashflow.game;

public interface ICommand {
    public String getDescription();

    public String getName();

    public void execute(Player player, String action, Game game);
}
