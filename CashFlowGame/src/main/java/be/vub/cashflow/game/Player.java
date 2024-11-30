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

    public Player(int palyerId, String name) {
        this.palyerId = palyerId;
        this.name = name;
    }

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
        this.income = income;
    }

    public double getExpens() {
        return expens;
    }

    public void setExpens(double expens) {
        this.expens = expens;
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
}
