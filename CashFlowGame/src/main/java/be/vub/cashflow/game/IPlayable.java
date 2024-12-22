package main.java.be.vub.cashflow.game;

public interface IPlayable {

    public void move(String direction);

    public void look();

    public void take(String itemName);

    public void drop(String itemName);
}
