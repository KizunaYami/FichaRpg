package com.infinitehorizon.ficharpgdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Repository extends SQLiteOpenHelper {
    private static final String NOME_DB = "db_rpg";
    private static final int VERSION = 1;

    public Repository(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
        getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_user = "CREATE TABLE usuario(" +
                "id INTEGER PRIMARY KEY," +
                "apelido TEXT," +
                "senha TEXT" +
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
                "    FOREIGN KEY (id_fk) REFERENCES usuario (id)" +
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
        String sql_attUser = "DROP TABLE IF EXISTS usuario;";
        String sql_attChar = "DROP TABLE IF EXISTS character;";
        String sql_attBag = "DROP TABLE IF EXISTS bag;";
        db.execSQL(sql_attUser);
        db.execSQL(sql_attChar);
        db.execSQL(sql_attBag);
        onCreate(db);
    }

    public void adicionarUsuario(Usuario user) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("apelido", user.getApelido());
        contentValues.put("senha", user.getSenha());
        getWritableDatabase().insert("usuario", null, contentValues);
    }

    public ArrayList<Usuario> getUsers(){
        ArrayList<Usuario> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from usuario",null);
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            Usuario usuario = new Usuario(cursor.getString(1),cursor.getString(2));
            usuario.setId(cursor.getInt(0));
            list.add(usuario);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public void addCharacter(Character a, int id) {
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
        contentValues.put("id_fk", id);
        getWritableDatabase().insert("character", null, contentValues);
    }

    public void attAttributes(Character character){
        String sql = "UPDATE `character` SET `lvl`='"+character.getLvl()+"'," +
                "`life`='"+character.getLife()+"'," +
                "`armor`='"+character.getArmor()+"'," +
                "`strength`='"+character.getStrength()+"'," +
                "`dexterity`='"+character.getDexterity()+"'," +
                "`constitution`='"+character.getConstitution()+"'," +
                "`intelligence`='"+character.getIntelligence()+"'," +
                "`wisdom`='"+character.getWisdom()+"'," +
                "`charisma`='"+character.getCharisma()+"'" +
                "WHERE id="+character.getId();
        getWritableDatabase().execSQL(sql);
    }

    public ArrayList<Character> getCharsList(int id){
        ArrayList<Character> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from character where id_fk="+id,null);
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            Character character = new Character(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            character.setId(cursor.getInt(0));
            list.add(character);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public Character getChar(int id){
        Character character = null;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from character where id="+id,null);
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            character = new Character(cursor.getString(1), cursor.getString(2), cursor.getString(3));
            character.setId(cursor.getInt(0));
            character.setLvl(cursor.getInt(4));
            character.setLife(cursor.getInt(5));
            character.setArmor(cursor.getInt(6));
            character.setStrength(cursor.getInt(7));
            character.setDexterity(cursor.getInt(8));
            character.setConstitution(cursor.getInt(9));
            character.setIntelligence(cursor.getInt(10));
            character.setWisdom(cursor.getInt(11));
            character.setCharisma(cursor.getInt(12));
            character.setId_fk(cursor.getInt(13));
        }
        cursor.close();
        return character;
    }

    public void deleteChar(Character character){
        String sql = "delete from character where id="+character.getId();
        getWritableDatabase().execSQL(sql);
    }

    public void addItem(Item item) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("item", item.getItem());
        contentValues.put("id_fk", item.getId_fk());
        getWritableDatabase().insert("bag", null, contentValues);
    }

    public ArrayList<Item> getItems(int id){
        ArrayList<Item> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from bag where id_fk="+id,null);
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            Item item = new Item(cursor.getString(1), cursor.getInt(2));
            item.setId(cursor.getInt(0));
            list.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public void deleteItem(Item item){
        String sql = "delete from bag where id="+item.getId();
        getWritableDatabase().execSQL(sql);
    }
}
