package com.example.cadastrologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RecuperarConta extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText campoEmail;

    private Button btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_conta);

        mAuth = FirebaseAuth.getInstance();

        btnRecuperar = findViewById(R.id.buttonEnviarEmail);

        campoEmail = findViewById(R.id.campoEmail);

        btnRecuperar.setOnClickListener(view -> {
            validarDados();
        });
    }

    private void validarDados(){
        String email = campoEmail.getText().toString().trim();
        if(!email.isEmpty()){

            recuperarConta(email);

        } else {
            Toast.makeText(this, "Insira seu e-mail", Toast.LENGTH_SHORT).show();
        }
    }

    private void recuperarConta(String email){
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                Toast.makeText(this, "Verifique seu e-mail para recuperar sua senha!", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Ocorreu algo errado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}