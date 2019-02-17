package com.musiccoder.clickergame2;

public class Entity {
    private int health;

    public Entity(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return this.health >= 0;
    }
}
