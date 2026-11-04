package com.unpri.charactermanager.model;

public class Character {

    // Atribut private (encapsulation)
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor 1: level awal 1
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        updateStats();
    }

    // Constructor 2: level ditentukan
    public Character(String name, CharacterType type, int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level harus minimal 1"
            );
        }

        this.name = name;
        this.type = type;
        this.level = level;
        updateStats();
    }

    // Getter dan setter nama
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan setter jenis karakter
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan setter level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level harus minimal 1"
            );
        }

        this.level = level;
        updateStats();
    }

    // Getter HP
    public int getHitPoints() {
        return hitPoints;
    }

    // Getter attack
    public int getAttack() {
        return attack;
    }

    // Poin 1 dan 2: atribut mana, getter, setter dengan validasi
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif"
            );
        }

        this.mana = mana;
    }

    // Menghitung ulang HP dan attack berdasarkan level
    private void updateStats() {
        this.hitPoints = 100 + (level - 1) * 20;
        this.attack = 10 + (level - 1) * 5;
    }

    // Poin 3: memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Level up
    public void levelUp() {
        level++;
        updateStats();

        System.out.println(
            name + " naik ke level " + level
        );
    }

    // Poin 4: toString menampilkan mana
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}

