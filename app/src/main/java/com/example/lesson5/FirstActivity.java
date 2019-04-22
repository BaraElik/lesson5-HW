package com.example.lesson5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.hawk.Hawk;

//=hawk activity
public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Hawk.init(this).build();

        Toast.makeText(FirstActivity.this, "FirstActivity", Toast.LENGTH_SHORT).show();
        setTitle("Hawk");

        final EditText input = findViewById(R.id.input);
        Button savebutton = findViewById(R.id.savebutton);
        Button clear = findViewById(R.id.clear);
        Button load = findViewById(R.id.load);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ukladamhodnotu = input.getText().toString();
                Hawk.put("input", ukladamhodnotu);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String smaz = input.getText().toString();
                Hawk.delete("input");
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String load = input.getText().toString();
                String load = Hawk.get("input");
            }
        });


        String ulozenahodnota = Hawk.get("input");
        input.setText(ulozenahodnota);


    }
}

