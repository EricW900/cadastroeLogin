package com.example.cadastrologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    private Button btnCadastrar; // Este botão serve para navegar a tela do Cadastro
    private Button btnLogin; // Este botão serve para navegar a tela de Login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.buttonCadastro); // Reconhecer o button de cadastro
        btnLogin = findViewById(R.id.buttonLogin); // Reconhecer o button de login

        // Lógica de navegação entre as telas de cadastro e login
        btnCadastrar.setOnClickListener(view -> {
            startActivity(new Intent(this, Cadastro.class));
        });

        btnLogin.setOnClickListener(viw -> {
            startActivity(new Intent(this, Login.class));
        });
    }
}