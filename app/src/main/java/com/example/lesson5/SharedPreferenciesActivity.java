package com.example.lesson5;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferenciesActivity extends AppCompatActivity {
    static  String folder = "cviceni5";
    static String dataName = "login";
    private SharedPreferences prefs;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        prefs = this.getSharedPreferences(folder, Context.MODE_PRIVATE);

        final EditText input = findViewById(R.id.input);
        Button savebutton = findViewById(R.id.savebutton);
        Button clear = findViewById(R.id.clear);
        Button load = findViewById(R.id.load);

        Toast.makeText(SharedPreferenciesActivity.this, "SharedPreferencies", Toast.LENGTH_SHORT).show();
        setTitle("Shared Preferencies");

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                prefs.edit().putString(dataName,text).apply();
            }
        });
        input.setText(prefs.getString(dataName,""));

        //clear edit text when Clear button is clicked
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.getText().clear();
            }
        });
        //load edit text when Clear button is clicked
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(prefs.getString(dataName,""));
            }
        });
    }
}
