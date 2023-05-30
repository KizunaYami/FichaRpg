package com.infinitehorizon.ficharpgdd;

public class Character {
    private final String name;
    private final String CLASS;
    private final String race;
    private int lvl;
    private int life;
    private int armor;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public Character(String name, String CLASS, String race) {
        this.name = name;
        this.CLASS = CLASS;
        this.race = race;
        this.lvl = 1;
        this.life = 10;
        this.armor = 0;
        this.strength = 0;
        this.dexterity = 0;
        this.constitution = 0;
        this.intelligence = 0;
        this.wisdom = 0;
        this.charisma = 0;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public String getName() {
        return name;
    }

    public String getCLASS() {
        return CLASS;
    }

    public String getRace() {
        return race;
    }

    public int getLvl() {
        return lvl;
    }

    public int getLife() {
        return life;
    }

    public int getArmor() {
        return armor;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }
}
