package com.musiccoder.clickergame2;

public class Encounter {

    public Encounter() {

    }

    public static void exchangeBlows(Player p, Enemy e) {
        playerAttacksEnemy(p,e);
        enemyAttacksPlayer(e,p);

        if (e.getCurrentHealth() < 0) {
            e.setCurrentHealth(0);
        }

        if (p.getCurrentHealth() <= 0) {
            p.setCurrentHealth(0);
            p.setCoins((int)(p.getCoins()-Math.round((p.getCoins()/10.0)))); //take a closer look when i have time
            return;
        }

        if (p.getCurrentHealth() > 0 && e.getCurrentHealth() == 0) {
            p.setCoins(p.getCoins() + e.getLootAmount());
        }
    }

    public static void playerAttacksEnemy(Player p, Enemy e) {
        e.setCurrentHealth(e.getCurrentHealth()-p.getSword().getAttackValue());
    }

    public static void enemyAttacksPlayer(Enemy e, Player p) {
        p.setCurrentHealth(p.getCurrentHealth()-e.getAttackValue());
    }
}
