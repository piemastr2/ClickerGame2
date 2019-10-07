package com.musiccoder.clickergame2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;


public class BuyPlantPop extends Activity {
    private TextView buyTreeTextView;
    private int numOfTreesToBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buyplantpop);

        Button buyTreeButton = (Button)findViewById(R.id.buyTreeButton);
        SeekBar buyTreeSeekBar = (SeekBar)findViewById(R.id.buyTreeSeekBar);
        final ProgressBar buyTreeProgressBar = (ProgressBar)findViewById(R.id.buyTreeProgressBar);

        buyTreeTextView = (TextView)findViewById(R.id.buyTreeTextView);

        buyTreeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                buyTreeProgressBar.setProgress(i);
                buyTreeTextView.setText(Integer.toString(i));
                numOfTreesToBuy = i;
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
        Player.getInstance().setCoins(Player.getInstance().getCoins()- MoneyTrees.moneyTreeCost);
    }
}
