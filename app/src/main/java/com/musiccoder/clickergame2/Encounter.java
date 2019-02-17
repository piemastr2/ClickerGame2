package com.musiccoder.clickergame2;

public class Encounter {

    public Encounter() {

    }

    public void battle(Player p, Enemy e) {
        while (p.isAlive() && e.isAlive()) {

        }

    }

    public void playerAttacksEnemy(Player p, Enemy e) {
        e.setHealth(e.getHealth()-p.getSword().getAttackValue());
    }

    public void enemyAttacksPlayer(Enemy e, Player p) {
        p.setHealth(p.getHealth()-e.getAttackValue());
    }
}
