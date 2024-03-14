package com.example.cadastrologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnVoltar = findViewById(R.id.buttonVoltar);

        btnVoltar.setOnClickListener(view -> {
            finish();
        });

    }
}