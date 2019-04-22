package com.example.lesson5;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//oboji dela to same jen Hawk lepe a efektivneji
        //button1 otevri aktivitu Hawk
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FirstActivity.class);
                //intent.putExtra("DATA","Posilam data z MainActivity...");
                MainActivity.this.startActivity(intent);
            }
        });
        //button2 otevri aktivitu Shared preferencies
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPreferenciesActivity.class);
                //intent.putExtra("DATA","Posilam data z MainActivity...");
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
