package com.infinitehorizon.ficharpgdd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class UserDashboardActivity extends AppCompatActivity implements CharacterAdapter.onClick {
    int id;
    Repository repository;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        bundle = savedInstanceState;

        id = (Integer) getIntent().getSerializableExtra("id");

        String user = (String) getIntent().getSerializableExtra("user");
        TextView textView = findViewById(R.id.idTextViewWelUser);
        textView.setText(user);

        repository = new Repository(this);
        ListView listView = findViewById(R.id.idListViewChar);
        CharacterAdapter characterAdapter = new CharacterAdapter(this,repository.getCharsList(id),this);
        listView.setAdapter(characterAdapter);
    }

    public void onClickCadastro(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("id", id);
        Intent intent = new Intent(this, CadastroPersonagemActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }

    @Override
    public void onClick(Character character) {
        repository.deleteChar(character);
        Toast.makeText(this, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
        recreate();
    }

    @Override
    public void clickChar(Character character) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("id",character.getId());
        Intent intent = new Intent(this, CharacterAttributesActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            recreate();
        }
    }
}