package com.musiccoder.clickergame2;

public class Encounter {

    public Encounter() {

    }

    public void battle(Player p, Enemy e) {
        while (p.isAlive() && e.isAlive()) {

        }

    }

    public void playerAttacksEnemy(Player p, Enemy e) {
        e.setCurrentHealth(e.getCurrentHealth()-p.getSword().getAttackValue());
    }

    public void enemyAttacksPlayer(Enemy e, Player p) {
        p.setCurrentHealth(p.getCurrentHealth()-e.getAttackValue());
    }
}
