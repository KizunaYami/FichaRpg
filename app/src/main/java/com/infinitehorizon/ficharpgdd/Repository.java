package com.infinitehorizon.ficharpgdd;

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
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_user = "CREATE TABLE Usuario(" +
                "id INTEGER PRIMARY KEY," +
                "apelido TEXT," +
                "senha STRING" +
                ")";
        String sql_char = "CREATE TABLE character(\n" +
                "    id INTEGER PRIMARY KEY,\n" +
                "    name text not null,\n" +
                "    CLASS text not null,\n" +
                "    race text not null,\n" +
                "    lvl INTEGER not null,\n" +
                "    life INTEGER not null,\n" +
                "    armor INTEGER not null,\n" +
                "    strength INTEGER not null,\n" +
                "    dexterity INTEGER not null,\n" +
                "    constitution INTEGER not null,\n" +
                "    intelligence INTEGER not null,\n" +
                "    wisdom INTEGER not null,\n" +
                "    charisma INTEGER not null,\n" +
                "    id_fk INTEGER not null," +
                "    FOREIGN KEY (id_fk) REFERENCES Usuario (id)" +
                ")";
        String sql_bag = "CREATE TABLE bag(\n" +
                "    id INTEGER PRIMARY KEY,\n" +
                "    item text,\n" +
                "    id_fk INTEGER NOT NULL,\n" +
                "    FOREIGN KEY (id_fk) REFERENCES character (id)\n" +
                ")";
        db.execSQL(sql_user);
        db.execSQL(sql_char);
        db.execSQL(sql_bag);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_attChar = "DROP TABLE IF EXISTS character;";
        String sql_attBag = "DROP TABLE IF EXISTS bag;";
        String sql_attuser = "DROP TABLE IF EXISTS Usuario;";
        db.execSQL(sql_attuser);
        db.execSQL(sql_attChar);
        db.execSQL(sql_attBag);
        onCreate(db);
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
  
  public void addCharacter(Character a){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", a.getName());
        contentValues.put("CLASS", a.getCLASS());
        contentValues.put("race", a.getRace());
        contentValues.put("lvl", a.getLvl());
        contentValues.put("life", a.getLife());
        contentValues.put("armor", a.getArmor());
        contentValues.put("strength", a.getStrength());
        contentValues.put("dexterity", a.getDexterity());
        contentValues.put("constitution", a.getConstitution());
        contentValues.put("intelligence", a.getIntelligence());
        contentValues.put("wisdom", a.getWisdom());
        contentValues.put("charisma", a.getCharisma());
        getWritableDatabase().insert("character",null,contentValues);
    }

    public void addItems(String item, int id){
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item);
        contentValues.put("id_fk",id);
        getWritableDatabase().insert("bag",null,contentValues);
    }




}
