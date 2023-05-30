package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
    }

    public void onClickCharacter(View view) {
        Intent intent = new Intent(this, CharacterAttributesActivity.class);
        startActivity(intent);
    }

    public void onClickCadastro(View view) {
        Intent intent = new Intent(this, CreateCharacterActivity.class);
        startActivity(intent);
    }
}