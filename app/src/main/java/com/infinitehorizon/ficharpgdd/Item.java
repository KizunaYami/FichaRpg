package com.infinitehorizon.ficharpgdd;

public class Item{
    private int id;
    private String item;
    private int id_fk;

    public Item(String item, int id_fk) {
        this.item = item;
        this.id_fk = id_fk;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public int getId_fk() {
        return id_fk;
    }
}
