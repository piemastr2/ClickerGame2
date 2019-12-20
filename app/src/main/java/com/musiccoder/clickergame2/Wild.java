package com.musiccoder.clickergame2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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

        final Player player = Player.getInstance();
        final AllWildInfo allWildInfo = new AllWildInfo();
        final ImageView enemyHpBar = findViewById(R.id.opponent_hp_current);
        final ImageView playerHpBar = findViewById(R.id.player_hp_current);
        enemyHpBar.getDrawable().setLevel(10000);
        playerHpBar.getDrawable().setLevel((int)(10000* player.getHpRatio()));

        Intent intent = getIntent();
        final int wildLevel = Integer.parseInt(intent.getStringExtra("position")) + 1;
        final Enemy enemy = new Enemy(allWildInfo.getWildInfo(wildLevel).getMaxHealth(), allWildInfo.getWildInfo(wildLevel).getAttackValue(),
                allWildInfo.getWildInfo(wildLevel).getLootAmount());

        final TextView enemyHealthTextView = (TextView) findViewById(R.id.opponent_hp_text);
        final TextView playerHealthTextView = (TextView) findViewById(R.id.player_hp_text);

        enemyHealthTextView.setText(Integer.toString(allWildInfo.getWildInfo(wildLevel).getCurrentHealth()) + "/" +
                Integer.toString(allWildInfo.getWildInfo(wildLevel).getMaxHealth()));

        Button attackButton = (Button) findViewById(R.id.attackbutton);

        playerHealthTextView.setText(Integer.toString(player.getCurrentHealth()) + "/" +
                Integer.toString(player.getMaxHealth()));

        attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Encounter.exchangeBlows(player, enemy);
                float playerHpRatio = player.getHpRatio();
                float enemyHpRatio = enemy.getHpRatio();
                enemyHpBar.getDrawable().setLevel((int)(10000 * enemyHpRatio));
                playerHpBar.getDrawable().setLevel((int)(10000* playerHpRatio));
                enemyHealthTextView.setText(Integer.toString(enemy.getCurrentHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
                playerHealthTextView.setText(Integer.toString(player.getCurrentHealth()) + "/" +
                        Integer.toString(player.getMaxHealth()));
                if (!player.isAlive() || !enemy.isAlive()) {
                    startActivity(new Intent(Wild.this, MainActivity.class));
                }
            }
        });

    }
}