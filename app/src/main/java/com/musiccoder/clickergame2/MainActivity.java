package com.musiccoder.clickergame2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Sword sword = new Sword(5);
        Player player = Player.getInstance(50,10,sword);

        //TextView healthTextView = (TextView)findViewById(R.id.)

        Button btn_shop = (Button)findViewById(R.id.Shop_main);
        Button btn_inn = (Button)findViewById(R.id.Inn_main);
        Button btn_wild = (Button)findViewById(R.id.Wild_main);

        setShopClickListener(btn_shop);

        setInnClickListener(player, btn_inn);

        setWildClickListener(btn_wild);
    }

    private void setShopClickListener(Button btn_shop) {
        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Shop.class));
            }
        });
    }

    private void setInnClickListener(Player player, Button btn_inn) {
        btn_inn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Inn.class);
                i.putExtra("numOfCoins", Integer.toString(player.getCoins()));
                startActivity(i);
            }
        });
    }

    private void setWildClickListener(Button btn_wild) {
        btn_wild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Wild.class));
            }
        });
    }
}
