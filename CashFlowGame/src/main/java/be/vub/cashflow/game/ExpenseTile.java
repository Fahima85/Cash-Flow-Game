package main.java.be.vub.cashflow.game;

public class ExpenseTile extends Tile {

    private double expenseAmount;

    public ExpenseTile(String name, TileType tileType, double value, String description, double expenseAmount) {
        super(name, tileType, value, description);
        this.expenseAmount = expenseAmount;
    }

//    @Override
//    public void applyEffect(Player player) {
//        System.out.println("Expense Tile: Adding expense of " + this.expenseAmount);
//        player.setExpens(this.expenseAmount);
//    }

}
