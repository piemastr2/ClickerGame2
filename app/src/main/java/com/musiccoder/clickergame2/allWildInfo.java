package com.musiccoder.clickergame2;

public class allWildInfo {

    public static Enemy wild1;
    public static Enemy wild2;
    public static Enemy wild3;
    public static Enemy wild4;
    public static Enemy wild5;
    public static Enemy wild6;
    public static Enemy wild7;
    public static Enemy wild8;
    public static Enemy wild9;
    public static Enemy wild10;

    public allWildInfo() {
        if (wild1 == null) {
            wild1 = new Enemy(60, 3, 1);
            wild2 = new Enemy(200, 30, 120);
            wild3 = new Enemy(500, 60, 220);
            wild4 = new Enemy(2500, 130, 320);
            wild5 = new Enemy(10000, 500, 6000);
            wild6 = new Enemy(27000, 1400, 14000);
            wild7 = new Enemy(40000, 3000,30000);
            wild8 = new Enemy(60000, 5500,60000);
            wild9 = new Enemy(75000, 7000, 90000);
            wild10 = new Enemy(90000, 9000,150000);
        }
    }

}

