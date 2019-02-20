package com.musiccoder.clickergame2;


public class MoneyTrees {
    public static final int moneyTreeCost = 5;
    public static MoneyTrees moneyTreesInstance;
    private int moneyTreesOwned;
    private int moneyTreesPlanted;
    private int moneyTreeProduction;
    private int moneyTreesAllowed;


    public MoneyTrees() {
        this.moneyTreesOwned = 0;
        this.moneyTreesPlanted = 0;
        this.moneyTreeProduction = 2;
        this.moneyTreesAllowed = 10;
    }

    public static MoneyTrees getInstance() {
        if (moneyTreesInstance == null) {
            moneyTreesInstance = new MoneyTrees();
        }
        return moneyTreesInstance;
    }

    public int getMoneyTreesOwned() {
        return this.moneyTreesOwned;
    }

    public void setMoneyTreesOwned(int moneyTreesOwned) {
        this.moneyTreesOwned = moneyTreesOwned;
    }
}