package com.maksim.demo;

import java.util.Scanner;

//import static com.maksim.demo.Main.isFighting;
//import static com.maksim.demo.Main.isPlaying;

public class Monster implements ICombat {

    Scanner scanner = new Scanner(System.in);
    private String name;

    private int health;

    private int damage;

    private int expYield;

    private int agility;

    private boolean coward;

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", damage=" + damage +
                ", agility=" + agility +
                '}';
    }



    public void monStatus () {
        System.out.println("Monster name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Damage: " + damage);
        System.out.println("Agility: " + agility);

    }

    public boolean getCoward () {
        return coward;
    }
    public void setCoward (boolean coward) {
        this.coward = coward;
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

    public void flee (Player p1) {
        if (coward== true) {
            System.out.println("monster tries to flee ");
            if (agility > p1.getAgility()) {
                System.out.println(getName() + "fled successfully");
              // isFighting = false;
            } else {
                System.out.println("monster failed to run");
            }

        }

    }

    @Override
    public void attacks(Monster m1, Player p1) {



        if (m1.getHealth() > 0) {
            if (coward) {
                fleeing (p1,m1);
            }else {

                    System.out.println(m1.getName() + " attacks for " + m1.getDamage());
                    p1.setHealth(p1.getHealth() - m1.getDamage());
                    System.out.println("Remaining player health: " + p1.getHealth());
                }

            }else {
                System.out.println("Monster is dead");
            }


        scanner.nextLine();

    }

    public boolean flee1;

    @Override
    public void fleeing(Player p1, Monster m1) {
        if (m1.coward) {
            System.out.println("monster is a coward");
            System.out.println("monster tries to run away");
            if (m1.getAgility() >= p1.getAgility()) {
                System.out.println("monster ran away successfully");
                flee1 = true;
            } else {
                System.out.println("monster failed to run away");
                flee1 = false;
                //p1.attacks(m1,p1);
            }
        }

    }
}
