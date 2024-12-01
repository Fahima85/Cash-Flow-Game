package main.java.be.vub.cashflow.game;

import main.java.be.vub.cashflow.accounting.Asset;
import main.java.be.vub.cashflow.accounting.Liability;

import java.util.List;

public class Player {
    int palyerId;
    String name;
    double income;
    double expens;
    List<Asset> assets;
    List<Liability> liabilities;
    Tile currentTile;

    /**
     *
     * @param palyerId
     * @param name
     */
    public Player(int palyerId, String name) {
        this.palyerId = palyerId;
        this.name = name;
    }

    /**
     *
     * @param palyerId
     * @param name
     * @param income
     * @param expens
     * @param assets
     * @param liabilities
     * @param currentTile
     */
    public Player(int palyerId, String name, double income, double expens,
                  List<Asset> assets, List<Liability> liabilities,
                  Tile currentTile) {
        this.palyerId = palyerId;
        this.name = name;
        this.income = income;
        this.expens = expens;
        this.assets = assets;
        this.liabilities = liabilities;
        this.currentTile = currentTile;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return Tile
     */
    public Tile getCurrentTile() {
        return currentTile;
    }

    public void setCurrentTile(Tile currentTile) {
        this.currentTile = currentTile;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income += income;
    }

    public double getExpens() {
        return expens;
    }

    public void setExpens(double expens) {
        this.expens += expens;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Liability> getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(List<Liability> liabilities) {
        this.liabilities = liabilities;
    }

    public double calculateCashFlow() {
        double totalCashFlow = 0;
        for (Asset asset : assets) {
            totalCashFlow += asset.getCashFlow();
        }
        return totalCashFlow;
    }

    public double getCash() {
        return this.getIncome() - this.getExpens();
    }
}
