package main.java.be.vub.cashflow.accounting;

public class Asset {
    private AssetType assetType;
    private String name;
    private double value;
    private double income;
    private double price;
    private double cashflow;

    /**
     *
     * @param name
     * @param price
     * @param cashflow
     */
    public Asset(String name, double price, double cashflow) {
        this.name = name;
        this.price = price;
        this.cashflow = cashflow;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.price;
    }

    public double getCashFlow() {
        return this.cashflow;
    }

}
