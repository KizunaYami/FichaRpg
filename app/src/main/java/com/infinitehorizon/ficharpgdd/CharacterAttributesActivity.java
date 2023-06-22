package com.infinitehorizon.ficharpgdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CharacterAttributesActivity extends AppCompatActivity {
    int id;
    Repository repository;
    Character character;
    Character characterAtt;
    EditText txtLVL;
    EditText txtLife;
    EditText txtArmor;
    EditText txtStr;
    EditText txtDex;
    EditText txtConst;
    EditText txtInteli;
    EditText txtWis;
    EditText txtChari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_attributes);

        id = (Integer) getIntent().getSerializableExtra("id");

        repository = new Repository(this);
        character = repository.getChar(id);
        characterAtt = new Character(character.getName(),character.getCLASS(),character.getRace());

        TextView txtName = findViewById(R.id.idTxtName);
        TextView txtRace = findViewById(R.id.idTxtRace);
        TextView txtClass = findViewById(R.id.idTxtClass);
        txtLVL = findViewById(R.id.idTxtLvl);
        txtLife = findViewById(R.id.idTxtLife);
        txtArmor = findViewById(R.id.idEditTxtArmor);
        txtStr = findViewById(R.id.idTxtStr);
        txtDex = findViewById(R.id.idTxtDex);
        txtConst = findViewById(R.id.idTxtCons);
        txtInteli = findViewById(R.id.idTxtInte);
        txtWis = findViewById(R.id.idTxtWis);
        txtChari = findViewById(R.id.idTxtChari);

        txtName.setText(character.getName());
        txtRace.setText(character.getRace());
        txtClass.setText(character.getCLASS());
        txtLVL.setText(character.getLvl()+"");
        txtLife.setText(character.getLife()+"");
        txtArmor.setText(character.getArmor()+"");
        txtStr.setText(character.getStrength()+"");
        txtDex.setText(character.getDexterity()+"");
        txtConst.setText(character.getConstitution()+"");
        txtInteli.setText(character.getIntelligence()+"");
        txtWis.setText(character.getWisdom()+"");
        txtChari.setText(character.getCharisma()+"");
    }

    public void onClickAtt(View view) {
        txtLVL = findViewById(R.id.idTxtLvl);
        txtLife = findViewById(R.id.idTxtLife);
        txtArmor = findViewById(R.id.idEditTxtArmor);
        txtStr = findViewById(R.id.idTxtStr);
        txtDex = findViewById(R.id.idTxtDex);
        txtConst = findViewById(R.id.idTxtCons);
        txtInteli = findViewById(R.id.idTxtInte);
        txtWis = findViewById(R.id.idTxtWis);
        txtChari = findViewById(R.id.idTxtChari);

        int lvl = Integer.parseInt(txtLVL.getText().toString());
        int life = Integer.parseInt(txtLife.getText().toString());
        int armor = Integer.parseInt(txtArmor.getText().toString());
        int str = Integer.parseInt(txtStr.getText().toString());
        int dex = Integer.parseInt(txtDex.getText().toString());
        int cons = Integer.parseInt(txtConst.getText().toString());
        int intel = Integer.parseInt(txtInteli.getText().toString());
        int wis = Integer.parseInt(txtWis.getText().toString());
        int chari = Integer.parseInt(txtChari.getText().toString());

        characterAtt.setId(id);
        characterAtt.setLvl(lvl);
        characterAtt.setLife(life);
        characterAtt.setArmor(armor);
        characterAtt.setStrength(str);
        characterAtt.setDexterity(dex);
        characterAtt.setConstitution(cons);
        characterAtt.setIntelligence(intel);
        characterAtt.setWisdom(wis);
        characterAtt.setCharisma(chari);

        repository.attAttributes(characterAtt);
        Toast.makeText(this, "Personagem atualizado", Toast.LENGTH_SHORT).show();
    }

    public void onClickBag(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("id",id);
        Intent intent = new Intent(this, BagActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}