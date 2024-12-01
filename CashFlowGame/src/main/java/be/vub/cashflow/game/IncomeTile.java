package main.java.be.vub.cashflow.game;

public class IncomeTile extends Tile {

    private double incomeAmount;

    /**
     * @param name
     * @param tileType
     * @param value
     * @param description
     * @param incomeAmount
     */
    public IncomeTile(String name, TileType tileType, double value, String description, double incomeAmount) {
        super(name, tileType, value, description);
        this.incomeAmount = incomeAmount;
    }

//    @Override
//    public void applyEffect(Player player) {
//        System.out.println("Income Tile: Adding income of " + this.incomeAmount);
//        player.setIncome(this.incomeAmount);
//    }
}
