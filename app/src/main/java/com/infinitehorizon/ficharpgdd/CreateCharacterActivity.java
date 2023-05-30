package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateCharacterActivity extends AppCompatActivity {
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);

        repository = new Repository(this);
    }

    public void onClickCreate(View view) {
        EditText txtName = findViewById(R.id.idEditTextName);
        EditText txtClass = findViewById(R.id.idEditTextClass);
        EditText txtRace = findViewById(R.id.idEditTextRace);

        repository.addCharacter(new Character(txtName.getText().toString(),txtClass.getText().toString(),txtRace.getText().toString()));

        finish();
    }
}