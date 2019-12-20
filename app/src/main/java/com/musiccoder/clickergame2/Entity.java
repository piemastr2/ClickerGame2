package com.musiccoder.clickergame2;

public class Entity {
    protected int currentHealth;
    protected int maxHealth;

    public Entity(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean isAlive() {
        return this.currentHealth > 0;
    }

    float getHpRatio() {
        return getCurrentHealth() / (float) getMaxHealth();
    }
}
