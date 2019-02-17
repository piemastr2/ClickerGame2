package com.musiccoder.clickergame2;

public class Enemy extends Entity {
    private int attackValue;

    public Enemy(int health, int attackValue) {
        super(health);
        this.attackValue = attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public int getAttackValue() {
        return this.attackValue;
    }
}
