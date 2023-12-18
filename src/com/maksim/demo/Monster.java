package com.maksim.demo;


import java.util.Scanner;
import static com.maksim.demo.Colours.*;
import static com.maksim.demo.Game.dbConnection;

public class Monster implements ICombat {

    Scanner scanner = new Scanner(System.in);
    private String name;
    private String info;

    private int health;
    private int maxHealth;

    private int damage;

    private int expYield;

    private int agility;

    private boolean coward;

    private boolean smart;

    private boolean flee;

    private boolean alive;

    private int stamina;
    private int maxStamina;

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
        System.out.println(WHITE_BRIGHT + name + RESET);
        System.out.println(GREEN_BRIGHT + "Health: " + health + "/" + maxHealth + RESET);
        System.out.println(RED_BRIGHT + "Damage: " + damage + RESET);
        System.out.println(YELLOW_BRIGHT + "Agility: " + agility + RESET);
        System.out.println("Stamina: " +stamina);
        System.out.println(info);

    }
    public boolean getAlive () {
        return alive;
    }

    public void setAlive (boolean alive) {
        this.alive = alive;
    }

    public boolean getSmart () {
        return smart;
    }
    public void setSmart (boolean smart) {
        this.smart = smart;
    }

    public int getStamina () {
        return stamina;
    }

    public void setStamina (int stamina) {
        this.stamina = stamina;
    }

    public int getMaxStamina () {
        return maxStamina;
    }
    public void setMaxStamina (int maxStamina) {
        this.maxStamina=maxStamina;
    }

    public boolean getCoward () {
        return coward;
    }
    public void setCoward (boolean coward) {
        this.coward = coward;
    }

    public boolean getFlee () {
        return flee;
    }

    public void setFlee (boolean flee) {
        this.flee = flee;
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
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth (int maxHealth) {
        this.maxHealth = maxHealth;
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

        if (health > 0 && stamina > 0) {


            if (damage >= p1.getHealth() && agility >= p1.getAgility() && coward) {
                System.out.println(WHITE_BRIGHT + name + RESET + " sees an opportunity");
                System.out.println(WHITE_BRIGHT + name + RESET + " becomes emboldened");
                coward = false;
            }

            if (stamina == 1) {
                System.out.println(WHITE_BRIGHT + name + RESET + YELLOW_BRIGHT +" is getting tired" + RESET);
            }




            if (coward && !p1.getDefend() ) {

                fleeing (p1,m1);
            }else {

                if (p1.getDefend() && coward && stamina <2) {
                    fleeing(p1,m1);
                } else {
                    if (smart && health <= maxHealth/8) {
                        tacticalRetreat(p1);
                    } else {
                        System.out.println(WHITE_BRIGHT + name + RESET + " attacks for " + RED + damage + RESET);
                        p1.setHealth(p1.getHealth() - damage);

                        dbConnection.updateHealth(p1);

                        System.out.println("Remaining player health: " + GREEN + p1.getHealth() + RESET);
                        stamina -= 1;

                    }


                }

                    }

            } else {

                if (stamina == 0) {
                    exhausted();

                } else {
                    System.out.println(WHITE_BRIGHT + name + RESET + " is dead");
                }

            }

        scanner.nextLine();

    }

    public void exhausted () {
        System.out.println(WHITE_BRIGHT + name + RESET + " is exhausted");
        System.out.println(WHITE_BRIGHT + name + RESET + " has to recover");
        stamina += maxStamina;
    }

    public void tacticalRetreat (Player p1) {
        if (stamina > 0) {
            if (smart) {
                System.out.println(WHITE_BRIGHT + name + RESET + " is hurt, attempts to retreat");
                if (agility > p1.getAgility() + p1.getAgility()/2) {
                    System.out.println(WHITE_BRIGHT + name + RESET + " retreated successfully");
                    System.out.println(WHITE_BRIGHT + name + RESET + " restored health and stamina to full");
                    setStamina(maxStamina);
                    setHealth( maxHealth );
                    dbConnection.updateBattleEnemyFled();
                    flee = true;

                } else {
                    System.out.println(WHITE_BRIGHT + name + RESET + " failed to retreat.");
                    flee = false;

                }
            }

        } else {
            System.out.println(WHITE_BRIGHT + name + RESET + " is too tired to retreat");
            exhausted();
            flee = false;

        }
    }


    public void dodge () {
            System.out.println(WHITE_BRIGHT + name + RESET + " dodged the attack");

    }

    @Override
    public void fleeing(Player p1, Monster m1) {


            if (stamina > 0) {
                if (coward) {

                    System.out.println(WHITE_BRIGHT + name + RESET + " tries to run away");
                    if (agility >= p1.getAgility()) {
                        System.out.println(WHITE_BRIGHT + name + RESET + " ran away successfully");
                        System.out.println(WHITE_BRIGHT + name + RESET + " restored health and stamina to full");
                        setStamina(maxStamina);
                        setHealth( maxHealth );
                        dbConnection.updateBattleEnemyFled();
                        flee = true;

                    } else {
                        System.out.println(WHITE_BRIGHT + name + RESET + " is too slow and failed to run away");
                        flee = false;




                    }
                }

            } else {
                    System.out.println(WHITE_BRIGHT + name + RESET + "is too tired to run away");
                    exhausted();
                    flee = false;

            }

    }

}
