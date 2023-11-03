package com.maksim.demo;

import java.util.Scanner;

public class Monster implements ICombat {

    Scanner scanner = new Scanner(System.in);
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

    @Override
    public void attacks(Monster m1, Player p1) {
        if (m1.getHealth() > 0) {
            System.out.println(m1.getName() + " attacks for " + m1.getDamage());
            p1.setHealth(p1.getHealth() - m1.getDamage());
            System.out.println("Remaining player health: " + p1.getHealth());
        } else {
            System.out.println("Monster is dead");
        }
        scanner.nextLine();

    }
}
