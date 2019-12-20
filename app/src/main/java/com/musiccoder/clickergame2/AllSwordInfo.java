package com.musiccoder.clickergame2;

public class AllSwordInfo {

    private Sword sword2;
    private Sword sword3;
    private Sword sword4;
    private Sword sword5;
    private Sword sword6;
    private Sword sword7;
    private Sword sword8;
    private Sword sword9;
    private Sword sword10;

    public AllSwordInfo() {
        sword2 = new Sword(7);
        sword3 = new Sword(10);
        sword4 = new Sword(20);
        sword5 = new Sword(30);
        sword6 = new Sword(45);
        sword7 = new Sword(70);
        sword8 = new Sword(100);
        sword9 = new Sword(120);
        sword10 = new Sword(150);

    }

    public Sword getSwordInfo(int level) {
        switch (level) {
            case 2: return sword2;
            case 3: return sword3;
            case 4: return sword4;
            case 5: return sword5;
            case 6: return sword6;
            case 7: return sword7;
            case 8: return sword8;
            case 9: return sword9;
            case 10: return sword10;
            default: return null;
        }
    }

}