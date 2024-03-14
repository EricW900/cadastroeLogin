package com.example.cadastrologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth; // Inicializando o Firebase

    private EditText campoEmail;
    private EditText campoSenha;

    private Button btnLogar;
    private Button btnEsqueceuSenha;

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnVoltar = findViewById(R.id.buttonVoltar); // Identificando o button para voltar

        mAuth = FirebaseAuth.getInstance();

        campoEmail = findViewById(R.id.campoEmail);
        campoSenha = findViewById(R.id.campoSenha);
        btnLogar = findViewById(R.id.buttonLogar);
        btnEsqueceuSenha = findViewById(R.id.buttonEsqueceuSenha);

        // Aqui ele retorna a classe anterior
        btnVoltar.setOnClickListener(view ->{
            finish();
        });

        // Aqui ele inicia o procedimento de Login
        btnLogar.setOnClickListener(view -> {
            validarDados();
        });

        btnEsqueceuSenha.setOnClickListener(view -> {
            startActivity(new Intent(this, RecuperarConta.class));
        });
    }

    private void validarDados(){
        String email = campoEmail.getText().toString().trim();
        String senha = campoSenha.getText().toString().trim();

        if(!email.isEmpty()){
            if(!senha.isEmpty()){
                logarConta(email, senha);
            } else {
                Toast.makeText(this, "Insira uma senha", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Insira seu e-mail", Toast.LENGTH_SHORT).show();
        }
    }

    private void logarConta(String email, String senha){
        mAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                finish();
                startActivity(new Intent(this, Home.class));
            } else {
                Toast.makeText(this, "Ocorreu algo errado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}