package com.example.cadastrologin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Cadastro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText campoEmail;
    private EditText campoSenha;
    private EditText campoConfirmarSenha;
    private Button confirmarCadastro;

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        mAuth = FirebaseAuth.getInstance(); // Inicializando a autenticação Firebase

        btnVoltar = findViewById(R.id.buttonVoltar); // Identificando o button

        campoEmail = findViewById(R.id.campoEmail);
        campoSenha = findViewById(R.id.campoSenha);
        campoConfirmarSenha = findViewById(R.id.campoConfirmarSenha);
        confirmarCadastro = findViewById(R.id.buttonConfirmarCadastro);

        // Aqui ele retorna a classe anterior
        btnVoltar.setOnClickListener(view -> {
            finish();
        });

        confirmarCadastro.setOnClickListener(view ->{
            validarDados();
        });

    }

    private void validarDados(){
        String email = campoEmail.getText().toString().trim();
        String senha = campoSenha.getText().toString().trim();
        String confirmarSenha = campoConfirmarSenha.getText().toString().trim();

        if(!email.isEmpty()){
            if(!senha.isEmpty()){
                if(!confirmarSenha.isEmpty()){
                    if(confirmarSenha.equals(senha)){

                        cadastrarConta(email, senha);

                    } else {
                        Toast.makeText(this, "As senhas não são iguais", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this, "Preencha o campo para confirmar sua senha", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Insira uma senha", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Insira seu e-mail", Toast.LENGTH_SHORT).show();
        }
    }

    private void cadastrarConta(String email, String senha){
        mAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(task -> {
            if(task.isSuccessful()) {
                finish();
                startActivity(new Intent(this, Home.class));
            } else {
                Toast.makeText(this, "Ocorreu algo errado!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}