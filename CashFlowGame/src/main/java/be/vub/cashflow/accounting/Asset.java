package main.java.be.vub.cashflow.accounting;

public class Asset extends Item {

    /**
     * @param name
     * @param description
     * @param price
     */
    public Asset(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public void use() {
        System.out.println("Using the asset: " + this.getName());
    }
}
