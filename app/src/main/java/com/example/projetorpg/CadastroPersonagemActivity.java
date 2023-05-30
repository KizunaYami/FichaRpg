package com.example.projetorpg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastroPersonagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_personagem);
    }

    ArrayList<Personagem> personagem = new ArrayList<Personagem>();
    public void cadastrarPersonagem(View view) {

        EditText cadastrarNomePersonagem = findViewById(R.id.editTextNomePersonagem);
        EditText cadastrarClassePersonagem = findViewById(R.id.editTextClassePersonagem);
        EditText confirmacaoRacaPersonagem = findViewById(R.id.editTextRacaPersonagem);

        String nomePersonagem = cadastrarNomePersonagem.getText().toString();
        String classePersonagem = cadastrarClassePersonagem.getText().toString();
        String racaPersonagem = confirmacaoRacaPersonagem.getText().toString();

        String error = "";

        if(nomePersonagem.equals("") || classePersonagem.equals("") || racaPersonagem.equals("")){

            error = error + "Campos vazios";

        }else if( error != "") {

            Toast.makeText(this, error, Toast.LENGTH_LONG).show();

        }else{

            personagem.add((new Personagem(nomePersonagem, classePersonagem, racaPersonagem)));
            Toast.makeText(this, "Personagem cadastrado", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra("CadastroPersonagemActivity", personagem);
            setResult(RESULT_OK, intent);

        }




    }
}