package com.maksim.demo;

import java.util.Random;
import java.util.Scanner;
import static com.maksim.demo.Colours.*;

public class Player implements ICombat {

    Game game = new Game();
    Scanner scanner = new Scanner(System.in);

    private boolean sword;  // Implement in Shop class
    private boolean shield; // Implement in Shop class
    private String name;
    private int strength;
    private int intelligence;  // Intelligence influences crit damage (double ordinary damage)
    private int agility;
    private int health;
    private int exp;
    private int level;
    private int defence;  // Consider removing
    private int baseDamage;
    private int enemiesDefeated;
    private boolean flee;
    private boolean alive;

    public Player () {

    }
    public Player(int strength, int intelligence, int agility, int health, int level, int baseDamage) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.level = level;
        this.baseDamage = baseDamage;
    }


    @Override
    public void fleeing(Player p1, Monster m1) {
        System.out.println(WHITE_BRIGHT + name + RESET + " tries to run away");
        if (p1.getAgility() > m1.getAgility() || m1.getStamina() == 0) {
            System.out.println(GREEN + "Ran away successfully" + RESET);
            flee = true;
        } else {
            System.out.println(RED + "Failed to run away" + RESET);
            flee = false;
            m1.attacks(m1,p1);
        }
    }




    public void getStatus () {
        System.out.printf(WHITE_BRIGHT +  "Name: %s %n" + RESET + RED, name );
        System.out.printf("Strength: %d %n" + RESET + BLUE, strength );
        System.out.printf("Intelligence: %d %n" + RESET + YELLOW , intelligence);
        System.out.printf("Agility: %d %n" + RESET + GREEN, agility);
        System.out.printf("Health: %d %n" + RESET + PURPLE, health);
        System.out.printf("Exp: %d %n" + RESET + CYAN , exp);
        System.out.printf("Level: %s %n" + RESET, level);


    }

    public boolean getShield () {
        return shield;
    }
    public void setShield (boolean shield) {
        this.shield = shield;
    }

    public boolean getSword() {
        return sword;
    }
    public void setSword (boolean sword) {
        this.sword = sword;
    }

    public boolean getAlive () {
        return alive;
    }
    public void setAlive (boolean alive) {
        this.alive = alive;
    }

    public boolean getFlee () {
        return flee;
    }
    public void setFlee (boolean flee) {
        this.flee = flee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnemiesDefeated () {
        return enemiesDefeated;
    }
    public void setEnemiesDefeated (int enemiesDefeated) {
        this.enemiesDefeated = enemiesDefeated;
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

    public boolean getDefend () {
        return defend;
    }
    public void setDefend (boolean defend) {
        this.defend = defend;;
    }



    public void turnOrder (Player p1, Monster m1) {
        int x = m1.getDamage();

        if (sword && shield) {
            m1.setDamage( m1.getDamage()/2 );
            System.out.println(WHITE_BRIGHT + name + RESET + " has sword and shield, damage halved");
        }

        if (p1.getAgility() > m1.getAgility()) {
            System.out.println(WHITE_BRIGHT + name + RESET + " is faster than " + m1.getName());

            attacks(m1,p1);

            if (m1.getHealth() > 0) {
                if (m1.getCoward()) {
                    m1.fleeing(p1,m1);
                } else {
                    m1.attacks(m1,p1);
                }
            } else {
                System.out.println(WHITE_BRIGHT + m1.getName() + RESET + " is dead");
            }


        } else {
            System.out.println(WHITE_BRIGHT + m1.getName() + RESET + " is faster");

            if (m1.getStamina() > 0) {
                m1.attacks(m1,p1);
                if (!m1.getFlee()) {
                    attacks(m1,p1);
                }


            } else {
                m1.attacks(m1,p1);
                attacks(m1,p1);
            }

        }
        m1.setDamage(x);

    }

    public void counterAttack (Monster m1) {
        m1.setHealth(m1.getHealth() - (calculateDamage()/2 ));
        System.out.println(WHITE_BRIGHT + name + RESET + " Counterattacks for " + ( calculateDamage()/2 ) );
        System.out.println("Remaining health of enemy: " +WHITE_BRIGHT + m1.getName() + RESET + " is " + GREEN_BRIGHT+ m1.getHealth() + "/" + m1.getMaxHealth()+ RESET);
        scanner.nextLine();

    }

    private boolean defend;
    public void defend (Monster m1, Player p1) {

        int x;

        while (defend) {
            System.out.println(WHITE_BRIGHT + name + RESET + " defends, enemy damage is halved");
            x = m1.getDamage();

            if (shield) {
                m1.setDamage( m1.getDamage()/4 );
                System.out.println(WHITE_BRIGHT + name + RESET + " defends with shield, damage halved further");
            } else {
                m1.setDamage( m1.getDamage()/2 );
            }

            m1.attacks(m1, p1);
            if (health > 0) {
                if (sword && shield && !m1.getFlee()) {
                    counterAttack (m1);
                }
            } else {
                alive = false;
            }


            m1.setDamage(x);

            defend = false;
        }

    }


    public void crit () {
        Random random = new Random();


        if (getIntelligence() >= random.nextInt(0,99)) {
            System.out.println(RED_BRIGHT+"Critical damage"+RESET);
            setBaseDamage(getBaseDamage() *2);
        }


    }

    @Override
    public void attacks(Monster m1, Player p1) {
        int x = baseDamage;

        if (p1.getHealth() > 0) {

            Random random = new Random();
            if (m1.getAgility() > agility + (agility/2) && 50 > random.nextInt(0,99) && m1.getStamina() > 0 && m1.getSmart()) {
                System.out.println(WHITE_BRIGHT + name + RESET+ " attacks..");
                System.out.println("but");
                m1.dodge();
            } else {

                crit();
                m1.setHealth(m1.getHealth() - calculateDamage() );
                System.out.println(p1.getName() + " attacks for " + RED + calculateDamage() + RESET );

            }




            setBaseDamage(x);  // ties to crit(p1);


            System.out.println("Remaining health of: " +m1.getName() + " is " + GREEN_BRIGHT+ m1.getHealth() + "/" + m1.getMaxHealth() + RESET);

        } else {

            game.gameOver(p1);

        }
        scanner.nextLine();

    }

    public int calculateDamage () {

        return getBaseDamage() + ( getStrength()*2/4 +1 );
    }


    public void growth () {

        setLevel(getLevel() + 1);
        setStrength(getStrength() + 2);
        setIntelligence(getIntelligence() + 2);
        setAgility(getAgility() + 2);

    }


}
