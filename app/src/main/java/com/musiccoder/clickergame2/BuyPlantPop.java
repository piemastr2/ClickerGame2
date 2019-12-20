package com.musiccoder.clickergame2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class BuyPlantPop extends Activity {
    private TextView buyTreeTextView;
    private int numOfTreesToBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buyplantpop);

        Button buyTreeButton = (Button)findViewById(R.id.buyButton);
        SeekBar buyTreeSeekBar = (SeekBar)findViewById(R.id.seekBar);
        TextView currentCoinsTreeShopText = (TextView)findViewById(R.id.currentCoinsText);
        final TextView treesTotalCostText = (TextView)findViewById(R.id.totalCost);

        buyTreeTextView = (TextView)findViewById(R.id.seekBarNumber);

        currentCoinsTreeShopText.setText("You have " + Integer.toString(Player.getInstance().getCoins()) + " coins");

        buyTreeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                buyTreeTextView.setText(Integer.toString(i));
                numOfTreesToBuy = i;
                treesTotalCostText.setText(Integer.toString(i) + " trees will cost " + Integer.toString(i * MoneyTrees.moneyTreeCost) + " coins");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buyTreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deductPlayerCoinsByMoneyTreeCost();
                MoneyTrees.getInstance().increaseNumOfMoneyTreesOwned(numOfTreesToBuy);
                Intent intent = new Intent(BuyPlantPop.this,MainActivity.class);
                intent.putExtra("numOfTreesToBuy",Integer.toString(numOfTreesToBuy));
                startActivity(intent);
            }
        });
    }

    private void deductPlayerCoinsByMoneyTreeCost() {
        Player.getInstance().setCoins(Player.getInstance().getCoins()- numOfTreesToBuy * MoneyTrees.moneyTreeCost);
    }
}
