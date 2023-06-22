package com.infinitehorizon.ficharpgdd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class BagActivity extends AppCompatActivity implements ItemAdapter.onClickItem {
    int id;
    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag);

        id = (Integer) getIntent().getSerializableExtra("id");
        repository = new Repository(this);
        ListView listView = findViewById(R.id.idListViewItems);
        ItemAdapter itemAdapter = new ItemAdapter(this,repository.getItems(id),this);
        listView.setAdapter(itemAdapter);
    }

    public void onClickAddItem(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("id",id);
        Intent intent = new Intent(this, CreateItemActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,1);
    }

    @Override
    public void onClickDelItem(Item item) {
        repository.deleteItem(item);
        Toast.makeText(this, "Deletado com sucesso", Toast.LENGTH_SHORT).show();
        recreate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            recreate();
        }
    }
}