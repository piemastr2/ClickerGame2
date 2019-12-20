package com.musiccoder.clickergame2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class UpgradeHealth extends Activity {
    private TextView seekBarNumber;
    private int numOfUpgradesToBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buyplantpop);

        Button buyUpgradesButton = findViewById(R.id.buyButton);
        SeekBar buyUpgradesSeekBar = findViewById(R.id.seekBar);
        TextView currentCoinsText = findViewById(R.id.currentCoinsText);
        final TextView totalCostText = findViewById(R.id.totalCost);

        seekBarNumber = findViewById(R.id.seekBarNumber);

        currentCoinsText.setText("You have " + Integer.toString(Player.getInstance().getCoins()) + " coins");

        buyUpgradesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarNumber.setText(Integer.toString(i));
                numOfUpgradesToBuy = i;
                //make the health upgrades class
                totalCostText.setText(Integer.toString(i) + " upgrades will cost " + Integer.toString(i * UpgradeInfo.HEALTH_UPGRADE_COST) + " coins");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buyUpgradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deductPlayerCoinsByHealthUpgradesCost();
                Player.getInstance().increaseHealth(numOfUpgradesToBuy);
                Intent intent = new Intent(UpgradeHealth.this,MainActivity.class);
                //intent.putExtra("numOfUpgradesToBuy",Integer.toString(numOfUpgradesToBuy));
                startActivity(intent);
            }
        });
    }

    private void deductPlayerCoinsByHealthUpgradesCost() {
        Player.getInstance().setCoins(Player.getInstance().getCoins()- numOfUpgradesToBuy * UpgradeInfo.HEALTH_UPGRADE_COST);
    }
}
