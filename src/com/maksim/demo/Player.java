package com.maksim.demo;

import java.util.Scanner;

public class Player implements Combat {

    Scanner scanner = new Scanner(System.in);

    private String name;
    private int strength;
    private int intelligence;
    private int agility;
    private int health;
    private int exp;
    private int level;
    private int baseDamage;

    public void getStatus () {
        System.out.printf("Name: %s %n" , name);
        System.out.printf("Strength: %d %n" , strength);
        System.out.printf("Intelligence: %d %n" , intelligence);
        System.out.printf("Agility: %d %n" , agility);
        System.out.printf("health: %d %n" , health);
        System.out.printf("Exp: %d %n" , exp);
        System.out.printf("level: %s %n" , level);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }




    @Override
    public int speed() {
        return 0;
    }

    @Override
    public void health() {
        int health;

    }

    @Override
    public void damage() {
        int damage;

    }

    @Override
    public void fight (Player p1, Monster m1) {
        boolean monsterAlive = true;
        boolean playerAlive = true;



        //do {
            System.out.println("Attacking!");
            System.out.println("Base damage: " + p1.getBaseDamage());
            System.out.println("Strength: " + p1.getStrength());
            System.out.println("Total power: " + (p1.getStrength() + p1.getBaseDamage()));

            System.out.println("Monster health: " + m1.getHealth());
            System.out.println(p1.getName() + " deals " + (p1.getStrength() + p1.getBaseDamage()) + " damage to " + m1.getName());
            m1.setHealth(m1.getHealth() - (p1.getStrength() + p1.getBaseDamage()));
            System.out.println("Remaining monster health: " + m1.getHealth());

            if (m1.getHealth() <= 0) {
                System.out.println("You defeated " + m1.getName());
                monsterAlive = false;
                // Monster dead, ceases to exist
                // System.out.println("m1 " + m1);

            }


            scanner.nextLine();

        if (monsterAlive) {

            System.out.println("Monster retaliates");
            System.out.println(m1.getName() + " inflicts " + m1.getDamage() + " damage on " + p1.getName());
            p1.setHealth(p1.getHealth() - m1.getDamage());
            System.out.println("Remaining player health: " + p1.getHealth());

            if (p1.getHealth() <= 0) {
                System.out.println("you lost");
                playerAlive = false;
            }
                scanner.nextLine();

        }

        //} while (monsterAlive && playerAlive);

       /* if (playerAlive) {
            System.out.println("You won");
        } else {
            System.out.println("Game over");
        } */

    }


    @Override
    public void fightSecond (Monster m1, Player p1) {

        boolean monsterAlive = true;
        boolean playerAlive = true;


        //do {
            System.out.println("Monster is attacking!");
            System.out.println("damage: " + m1.getDamage());

            System.out.println(p1.getName() + "'s health: " + p1.getHealth());
            System.out.println(m1.getName() + " deals " + (m1.getDamage()) + " damage to " + p1.getName());
            p1.setHealth(p1.getHealth() - (m1.getDamage()));
            System.out.println("Remaining " +p1.getName() + " health: " + p1.getHealth());

            if (p1.getHealth() <= 0) {
                System.out.println("You lost ");
                playerAlive = false;
                // Monster dead, ceases to exist
                //System.out.println("m1 " + m1);

            }


            scanner.nextLine();

            if (playerAlive) {

                System.out.println( p1.getName() + " retaliates");
                System.out.println(p1.getName() + " inflicts " + (p1.getBaseDamage() + p1.getStrength() )+ " damage on " + m1.getName());
                m1.setHealth(m1.getHealth() - ( p1.getBaseDamage() + p1.getStrength() ) );
                System.out.println("Remaining monster health: " + m1.getHealth());

                if (m1.getHealth() <= 0) {
                    System.out.println("you defeated: " + m1.getName());
                    monsterAlive = false;
                }
                scanner.nextLine();

            }

        //} while (monsterAlive && playerAlive);

       /* if (playerAlive) {
            System.out.println("You won");
        } else {
            System.out.println("Game over");
        }*/

    }

    public void turnOrder (Player p1, Monster m1) {

        if (p1.getAgility() > m1.getAgility()) {
            System.out.println(p1.getName() + " is faster than " + m1.getName());
            p1.fight (p1,m1);

        } else {
            System.out.println("monster is faster");
            // Insert method for monster attacking first
            p1.fightSecond (m1, p1);
        }

    }


    public void defend (Monster m1, Player p1) {
        boolean defend = true;
        int x;

        while (defend) {
            System.out.println(p1.getName() + " defends, monster's damage is halved");
            x = m1.getDamage();
            m1.setDamage(m1.getDamage()/2);
            monsterAttacks(m1, p1);
            m1.setDamage(x);

            defend = false;
        }

    }

    public void monsterAttacks (Monster m1, Player p1) {
        if (m1.getHealth() > 0) {
            System.out.println("monster attacks for " + m1.getDamage());
            p1.setHealth(p1.getHealth() - m1.getDamage());
            System.out.println("Remaining player health: " + p1.getHealth());
        } else {
            System.out.println("Monster is dead");
        }


    }

    public void flee (Player p1, Monster m1) {

        Main main = new Main();


        if (p1.getAgility() > m1.getAgility()) {
            System.out.println("Successfully ran away!");
            main.gameMenu(p1,m1);
        } else {
            System.out.println("Failed to run away");
            monsterAttacks(m1,p1);
        }

    }

}
