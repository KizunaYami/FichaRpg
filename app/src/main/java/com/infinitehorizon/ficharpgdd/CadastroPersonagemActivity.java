package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPersonagemActivity extends AppCompatActivity {
    Repository repository;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_personagem);

        repository = new Repository(this);
        id = (Integer) getIntent().getSerializableExtra("id");
    }

    public void cadastrarPersonagem(View view) {
        EditText cadastrarNomePersonagem = findViewById(R.id.editTextNomePersonagem);
        EditText cadastrarClassePersonagem = findViewById(R.id.editTextClassePersonagem);
        EditText confirmacaoRacaPersonagem = findViewById(R.id.editTextRacaPersonagem);
        String nomePersonagem = cadastrarNomePersonagem.getText().toString();
        String classePersonagem = cadastrarClassePersonagem.getText().toString();
        String racaPersonagem = confirmacaoRacaPersonagem.getText().toString();

        if(!nomePersonagem.equals("") && !classePersonagem.equals("") && !racaPersonagem.equals("")){
            repository.addCharacter(new Character(nomePersonagem, classePersonagem, racaPersonagem), id);
            Toast.makeText(this, "Personagem cadastrado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            setResult(1,intent);
            finish();
        }else{
            Toast.makeText(this, "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }
}