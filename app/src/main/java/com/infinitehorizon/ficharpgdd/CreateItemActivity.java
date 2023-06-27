package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateItemActivity extends AppCompatActivity {
    int id;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);

        id = (Integer) getIntent().getSerializableExtra("id");
        repository = new Repository(this);
    }

    public void onClickSaveItem(View view) {
        EditText editText = findViewById(R.id.idEditTextNewItem);
        String newiItem = editText.getText().toString();
        
        if(!newiItem.equals("")){
            Item item = new Item(newiItem,id);
            repository.addItem(item);
            Toast.makeText(this, "Item salvo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            setResult(1,intent);
            finish();
        }else{
            Toast.makeText(this, "Digite o nome de um item", Toast.LENGTH_SHORT).show();
        }
    }
}