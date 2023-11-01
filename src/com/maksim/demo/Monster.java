package com.maksim.demo;

public class Monster {

    private String name;

    private int health;

    private int damage;

    private int expYield;

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", agility=" + agility +
                '}';
    }

    private int agility;

    public void monStatus () {
        System.out.println("Monster name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Agility: " + agility);

    }

    public int getExpYield () {
        return expYield;
    }
    public void setExpYield (int expYield) {
        this.expYield = expYield;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}
