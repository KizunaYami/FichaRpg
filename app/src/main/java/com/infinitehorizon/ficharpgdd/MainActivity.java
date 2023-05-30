package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onClickDashboard(View view) {
        Intent intent = new Intent(this, UserDashboardActivity.class);
        startActivity(intent);

    public void btLogin(View view){

        EditText editApelido = findViewById(R.id.editTxtApelido);
        EditText editSenha = findViewById(R.id.editTxtSenha);

        String apelido = editApelido.getText().toString();
        String senha = editSenha.getText().toString();

        if(apelido.equals("") || senha.equals("")){

            Toast.makeText(this, "Campos vazios", Toast.LENGTH_LONG).show();


        }



    }


    public void btCadastro(View view) {

        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }
}