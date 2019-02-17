package com.musiccoder.clickergame2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Inn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inn);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Intent intent = getIntent();
        String numOfCoins = intent.getStringExtra("numOfCoins");

        TextView currentCoinsTextView = (TextView)findViewById(R.id.currentcoinsinn);

        currentCoinsTextView.setText("You currently have" + numOfCoins + " coins");
    }
}
