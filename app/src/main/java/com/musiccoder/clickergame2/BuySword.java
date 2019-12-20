package com.musiccoder.clickergame2;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BuySword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_sword);

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("Sword2");
        arrayList.add("Sword3");
        arrayList.add("Sword4");
        arrayList.add("Sword5");
        arrayList.add("Sword6");
        arrayList.add("Sword7");
        arrayList.add("Sword8");
        arrayList.add("Sword9");
        arrayList.add("Sword10");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AllSwordInfo allSwordInfo = new AllSwordInfo();
                Player.getInstance().setSword((allSwordInfo.getSwordInfo(position+2)));
                deductPlayerCoinsBySwordCost();
                
                Intent intent = new Intent(BuySword.this, MainActivity.class);
                //intent.putExtra("position",Integer.toString(position));
                startActivity(intent);
            }
        });

    }

    private void deductPlayerCoinsBySwordCost() {
    }
}
