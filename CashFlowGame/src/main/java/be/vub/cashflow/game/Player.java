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
    int turnOrder;
}
