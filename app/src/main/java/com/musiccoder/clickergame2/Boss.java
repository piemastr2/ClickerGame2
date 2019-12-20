package com.musiccoder.clickergame2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Boss extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        final AllBossInfo allBossInfo = new AllBossInfo();

        Intent intent = getIntent();
        int bossLevel = Integer.parseInt(intent.getStringExtra("position")) + 1;
        final Enemy enemy = new Enemy(allBossInfo.getBossInfo(bossLevel).getMaxHealth(), allBossInfo.getBossInfo(bossLevel).getAttackValue(),
                allBossInfo.getBossInfo(bossLevel).getLootAmount());

        final TextView healthTextView = (TextView) findViewById(R.id.opponent_hp_text);
        final TextView playerHealthTextView = (TextView) findViewById(R.id.player_hp_text);

        healthTextView.setText(Integer.toString(allBossInfo.getBossInfo(bossLevel).getCurrentHealth()) + "/" +
                Integer.toString(allBossInfo.getBossInfo(bossLevel).getMaxHealth()));

        Button attackButton = (Button) findViewById(R.id.attackbutton);

        playerHealthTextView.setText(Integer.toString(Player.getInstance().getCurrentHealth()) + "/" +
                Integer.toString(Player.getInstance().getMaxHealth()));

        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Encounter.exchangeBlows(Player.getInstance(), enemy);
                healthTextView.setText(Integer.toString(enemy.getCurrentHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
                playerHealthTextView.setText(Integer.toString(Player.getInstance().getCurrentHealth()) + "/" +
                        Integer.toString(Player.getInstance().getMaxHealth()));
                if (!Player.getInstance().isAlive() || !enemy.isAlive()) {
                    startActivity(new Intent(Boss.this, MainActivity.class));
                }
            }
        });
    }
}