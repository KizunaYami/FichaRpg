package com.infinitehorizon.ficharpgdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Repository extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_character";
    private static final int VERSION = 1;

    public Repository(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
        getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
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
                "    charisma INTEGER not null\n" +
                ")";
        String sql_bag = "CREATE TABLE bag(\n" +
                "    id INTEGER PRIMARY KEY,\n" +
                "    item text,\n" +
                "    id_fk INTEGER NOT NULL,\n" +
                "    FOREIGN KEY (id_fk) REFERENCES character (id)\n" +
                ")";
        sqLiteDatabase.execSQL(sql_char);
        sqLiteDatabase.execSQL(sql_bag);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql_attChar = "DROP TABLE IF EXISTS character;";
        String sql_attBag = "DROP TABLE IF EXISTS bag;";
        sqLiteDatabase.execSQL(sql_attChar);
        sqLiteDatabase.execSQL(sql_attBag);
        onCreate(sqLiteDatabase);
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
