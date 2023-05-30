package com.example.projetorpg;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Repository extends SQLiteOpenHelper {

    private static final String NOME_DB = "db_rpg";
    private static final int VERSION = 1;

    public Repository(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL ("CREATE TABLE Usuario ( id INTEGER PRIMARY KEY, apelido TEXT, senha STRING )");

        db.execSQL("CREATE TABLE Personagem ( id INTEGER PRIMARY KEY, nome TEXT, classe TEXT, raca TEXT )");

        db.execSQL("CREATE TABLE Itens ( id INTEGER PRIMARY KEY, descricao TEXT )");


        Log.i("Usuario","sql criação tabela usuario" + db);
        Log.i("Personagem","sql criação tabela Personagem" + db);
        Log.i("Itens","sql criação tabela Itens" + db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void adicionarUsuario (Usuario user){

        ContentValues contentValues = new ContentValues();
        contentValues.put("apelido",user.getApelido());
        contentValues.put("senha",user.getSenha());

    };

    public void adicionarPersonagem (Personagem personagem){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome",personagem.getNome());
        contentValues.put("classe",personagem.getClasse());
        contentValues.put("raca",personagem.getRaca());

    };

    public void adicionarItem (Item item){

        ContentValues contentValues = new ContentValues();
        contentValues.put("descricao", item.getDescricao() );


    };

    public void deletarUsuario (Usuario usuario){

        String db = " delete from usuario  where id = " + usuario.getId();
        getWritableDatabase().execSQL(db);
        Log.i("usuario","sql delete " + db);

    }
    public void deletarPersonagem (Personagem personagem){

        String db = " delete from personagem where id = " + personagem.getId();
        getWritableDatabase().execSQL(db);
        Log.i("personagem", "sql delete " + db);

    }
    public void deletarItem (Item item){

        String db = " delete from item where id = " + item.getId();
        getWritableDatabase().execSQL(db);
        Log.i("Item", "sql delete " + db);


    }





}
