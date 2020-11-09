package com.example.cs50.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PokemonActivity extends AppCompatActivity {
    private TextView nameTextView;
    private TextView numberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number",0);

        nameTextView = findViewById(R.id.pokemon_name);
        numberTextView = findViewById(R.id.pokemon_number);

        numberTextView.setText(String.format("#%03d",number));
        nameTextView.setText(name);
    }
}