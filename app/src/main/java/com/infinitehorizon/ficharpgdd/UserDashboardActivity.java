package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserDashboardActivity extends AppCompatActivity {
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        id = (Integer) getIntent().getSerializableExtra("id");
    }

    public void onClickCharacter(View view) {
        Intent intent = new Intent(this, CharacterAttributesActivity.class);
        startActivity(intent);
    }

    public void onClickCadastro(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("id", id);
        Intent intent = new Intent(this, CadastroPersonagemActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}