package com.musiccoder.clickergame2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int numOfTreesToBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Intent intent = getIntent();
            //numOfTreesToBuy = Integer.valueOf(intent.getStringExtra("numOfTreesToBuy"));
            //Toast.makeText(MainActivity.this,Integer.toString(numOfTreesToBuy),Toast.LENGTH_LONG).show();
        }

        Sword sword = new Sword(5);
        Player player = Player.getInstance(50,10,sword);

        Button wildButton = (Button)findViewById(R.id.Wild_main);
        Button bossButton = (Button)findViewById(R.id.Boss_main);
        Button shopButton = (Button)findViewById(R.id.Shop_main);
        Button upgradeButton = (Button)findViewById(R.id.Upgrade_main);
        Button plantButton = (Button)findViewById(R.id.Plant_main);
        Button innButton = (Button)findViewById(R.id.Inn_main);

        TextView hpTextView = (TextView)findViewById(R.id.mainHpText);
        TextView weaponDamageText = (TextView)findViewById(R.id.mainWeaponDmgText);
        TextView mainCoinsText = (TextView)findViewById(R.id.mainCoinsText);

        hpTextView.setText(Integer.toString(player.getCurrentHealth()) + "/" + Integer.toString(player.getMaxHealth()));
        weaponDamageText.setText("Weapon Damage: " + Integer.toString(player.getSword().getAttackValue()));
        mainCoinsText.setText("Coins: " + Integer.toString(Player.getInstance().getCoins()));

        ImageView playerHpBar = findViewById(R.id.player_hp_current);
        playerHpBar.getDrawable().setLevel((int)(10000* player.getHpRatio()));

        setWildClickListener(wildButton);
        setBossClickListener(bossButton);
        setShopClickListener(shopButton);
        setUpgradeClickListener(upgradeButton);
        setPlantClickListener(plantButton);
        setInnClickListener(innButton);
    }

    private void setShopClickListener(Button shopButton) {
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ShopActivity.class));
            }
        });
    }

    private void setUpgradeClickListener(Button upgradeButton) {
        upgradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,UpgradeActivity.class));
            }
        });
    }

    private void setInnClickListener(Button innButton) {
        innButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Inn.class);
                i.putExtra("numOfCoins", Integer.toString(Player.getInstance(0,0,null).getCoins()));
                startActivity(i);
            }
        });
    }

    private void setPlantClickListener(Button plantButton) {
        plantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PlantTree.class));
            }
        });
    }

    private void setWildClickListener(Button wildButton) {
        wildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ChooseALevelWild.class));
            }
        });
    }

    private void setBossClickListener(Button bossButton) {
        bossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ChooseALevelBoss.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onPause();
    }
}
