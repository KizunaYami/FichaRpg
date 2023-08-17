package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Repository repository;
    NavigationView navigationView;
    Switch sw;
    boolean darkmode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
//Dienifer esteve aqui
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = new Repository(this);
        navigationView = findViewById(R.id.idNav);

        sw = findViewById(R.id.idSwitch);
        sharedPreferences = getSharedPreferences("mode", Context.MODE_PRIVATE);
        darkmode = sharedPreferences.getBoolean("dark",false);

        onSwitch();
    }

    public void btCadastro(View view) {
        Intent intent = new Intent(this, CadastroUsuarioActivity.class);
        startActivity(intent);
    }

    public void onClickBtLogin(View view) {
        EditText editApelido = findViewById(R.id.editTxtApelido);
        EditText editSenha = findViewById(R.id.editTxtSenha);
        String apelido = editApelido.getText().toString();
        String senha = editSenha.getText().toString();
        ArrayList<Usuario> list = repository.getUsers();

        if(!apelido.equals("") && !senha.equals("")){
            boolean userOk = false;
            for(Usuario usuario: list){
                if(usuario.getApelido().equals(apelido) && usuario.getSenha().equals(senha)){
                    userOk = true;
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("id",usuario.getId());
                    bundle.putSerializable("user",usuario.getApelido());
                    Intent intent = new Intent(this, UserDashboardActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                }
            }
            if(userOk == false){
                Toast.makeText(this, "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Campos vazios", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickMenu(View view) {
        navigationView.setVisibility(View.VISIBLE);
    }

    public void onClickCloseLay(View view) {
        navigationView.setVisibility(View.INVISIBLE);
    }

    public void onClickAbout(View view) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
        navigationView.setVisibility(View.INVISIBLE);
    }

    public void onSwitch(){
        if(darkmode){
            sw.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(darkmode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("dark",false);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("dark",true);
                }
                editor.apply();
            }
        });
    }
}