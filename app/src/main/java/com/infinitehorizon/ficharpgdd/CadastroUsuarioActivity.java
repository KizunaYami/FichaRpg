package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastroUsuarioActivity extends AppCompatActivity {
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        repository = new Repository(this);
    }


    public void CadastrarUsuario(View view) {

        EditText cadastrarApelido = findViewById(R.id.editTextCadastroApelido);
        EditText cadastrarSenha = findViewById(R.id.editTextCadastroSenha);
        EditText confirmacaoSenha = findViewById(R.id.editTextConfirmarSenha);
        String error = "";


        String apelido = cadastrarApelido.getText().toString();
        String senha = cadastrarSenha.getText().toString();
        String confirmarSenha = confirmacaoSenha.getText().toString();

        if(apelido.equals("") || senha.equals("") || confirmarSenha.equals("")){

            error = error + "Campos vazios";

        }if(!senha.equals(confirmarSenha)){

            error = error + "As senhas não correspondem";

        }if(error != ""){

            Toast.makeText(this,error, Toast.LENGTH_LONG).show();
        }

        else{
            repository.adicionarUsuario(new Usuario(apelido,senha));
            Toast.makeText(this, "Usuario cadastrado", Toast.LENGTH_SHORT).show();

            finish();

        }




    }




}