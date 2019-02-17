package com.musiccoder.clickergame2;

public class Player extends Entity{
    private int coins;
    private Sword sword;

    public Player(int health, int coins, Sword sword) {
        super(health);
        this.coins = coins;
        this.sword = sword;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }
}
