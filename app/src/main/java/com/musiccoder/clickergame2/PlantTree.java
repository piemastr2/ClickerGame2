package com.musiccoder.clickergame2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by 515852 on 10/6/2019.
 */

public class PlantTree extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        TextView numOfTreesTextView = (TextView)findViewById(R.id.numOfTrees);
        numOfTreesTextView.setText(Integer.toString(MoneyTrees.getInstance().getMoneyTreesOwned()));

    }


}