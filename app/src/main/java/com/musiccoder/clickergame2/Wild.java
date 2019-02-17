package com.musiccoder.clickergame2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Wild extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        AllWildInfo allWildInfo = new AllWildInfo();

        Intent intent = getIntent();
        int wildLevel = Integer.parseInt(intent.getStringExtra("position"))+1;

        TextView healthTextView = (TextView)findViewById(R.id.hptext2);

        healthTextView.setText(Integer.toString(allWildInfo.getWildInfo(wildLevel).getCurrentHealth()) + "/" +
                                    Integer.toString(allWildInfo.getWildInfo(wildLevel).getMaxHealth()));





    }
}