package com.maksim.demo;

import java.util.Random;
import java.util.Scanner;

public class Player implements ICombat {

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
    private int baseDamage;
    private boolean flee;
    private boolean alive;

    public Player(int strength, int intelligence, int agility, int health, int level, int baseDamage) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.health = health;
        this.level = level;
        this.baseDamage = baseDamage;
    }



    /*public void tryFlee(Player p1, Monster m1) {

    }*/
    @Override
    public void fleeing(Player p1, Monster m1) {
        System.out.println(p1.getName() + " tries to run away");
        if (p1.getAgility() > m1.getAgility()) {
            System.out.println("Ran away successfully");
            flee = true;
        } else {
            System.out.println("Failed to run away");
            flee = false;
            m1.attacks(m1,p1);
        }
    }


    public void takeDamage (int damage) {   // kan finnas i ICombat interface eftersom både player och monster påverkas
        setHealth(getHealth() - damage);
    }

    public void calculateExpToLvl (int amountOfExp) {
        for (int i = amountOfExp; i > 0 ; i--) {
            //System.out.println(i);
            setExp(getExp() + 1);

            if (getExp() == (100 + (getLevel()^2) -1  ) ) {
                setLevel(getLevel() + 1);
                setExp(0);
            }

        }

        System.out.println("How much exp left?");
        System.out.println(getExp());
        System.out.println("Player level");
        System.out.println(getLevel());


    }



    public void getStatus () {
        System.out.printf("Name: %s %n" , name);
        System.out.printf("Strength: %d %n" , strength);
        System.out.printf("Intelligence: %d %n" , intelligence);
        System.out.printf("Agility: %d %n" , agility);
        System.out.printf("health: %d %n" , health);
        System.out.printf("Exp: %d %n" , exp);
        System.out.printf("level: %s %n" , level);

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










    /*@Override
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
                p1.setExp(p1.getExp() + m1.getExpYield());
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




   /* @Override
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
                    p1.setExp(p1.getExp() + m1.getExpYield());

                    monsterAlive = false;
                }
                scanner.nextLine();

            } */

        //} while (monsterAlive && playerAlive);

       /* if (playerAlive) {
            System.out.println("You won");
        } else {
            System.out.println("Game over");
        }*/



    public void turnOrder (Player p1, Monster m1) {
        int x = m1.getDamage();

        if (sword && shield) {
            m1.setDamage( m1.getDamage()/2 );
            System.out.println(name + " has sword and shield, damage halved");
        }

        if (p1.getAgility() > m1.getAgility()) {
            System.out.println(p1.getName() + " is faster than " + m1.getName());
            //p1.fight (p1,m1);
            attacks(m1,p1);

            if (m1.getHealth() > 0) {
                if (m1.getCoward()) {
                    m1.fleeing(p1,m1);
                } else {
                    m1.attacks(m1,p1);
                }
            } else {
                System.out.println("monster is dead inside Player turnOrder");
            }

           /* if (m1.getCoward()) {
                m1.fleeing(p1,m1);
            } else {
                m1.attacks(m1,p1);
            } */

            //monsterAttacks(m1,p1);

        } else {
            System.out.println("monster is faster");
            // Insert method for monster attacking first
            //p1.fightSecond (m1, p1);
            //monsterAttacks(m1,p1);

            if (/*m1.getCoward() && */ m1.getStamina() > 0) {
                //System.out.println("if ");
                m1.attacks(m1,p1);
                if (!m1.getCoward()) {
                    attacks(m1,p1);
                }


            } else {
                System.out.println("else in turnOrder");
                m1.attacks(m1,p1);
                attacks(m1,p1);
            }
            //m1.attacks(m1,p1);
            //attacks(m1,p1);



        }
        m1.setDamage(x);

    }

    public void counterAttack (Player p1, Monster m1) {
        m1.setHealth(m1.getHealth() - (p1.getBaseDamage() +p1.getStrength()) );
        System.out.println(p1.getName() + " has sword and shield, counterattacks for " + (p1.getBaseDamage() + p1.getStrength())  );
        System.out.println("Remaining health of enemy: " +m1.getName() + " is " + m1.getHealth());
        scanner.nextLine();

    }

    private boolean defend;
    public void defend (Monster m1, Player p1) {

        int x;

        while (defend) {
            System.out.println(p1.getName() + " defends, monster's damage is halved");
            x = m1.getDamage();

            if (shield) {
                m1.setDamage( m1.getDamage()/4 );
                System.out.println(name + " defends with shield, damage halved further");
            } else {
                m1.setDamage( m1.getDamage()/2 );
                System.out.println(name + " has no shield");
            }

            System.out.println("m1.attacks(m1, p1); in defend");
            m1.attacks(m1, p1);
            if (health > 0) {
                if (sword && shield) {
                    counterAttack (p1,m1);
                }
            } else {
                alive = false;
            }


            m1.setDamage(x);

            defend = false;
        }

    }

    /*public void playerAttacks (Player p1, Monster m1) {
        if (p1.getHealth() > 0) {
            System.out.println(p1.getName() + " attacks for " + (p1.getBaseDamage() + p1.getStrength()) );
            m1.setHealth(m1.getHealth() - (p1.getBaseDamage() +p1.getStrength()) );
            System.out.println("Remaining monster health: " + m1.getHealth());

        } else {
            System.out.println("You are dead");
            System.out.println("game over");
            System.exit(0);
        }
        scanner.nextLine();
    } */

    public void crit (Player p1) {
        Random random = new Random();


        if (p1.getIntelligence() >= random.nextInt(0,99)) {
            System.out.println("Critical damage");
            p1.setBaseDamage(getBaseDamage() *2);
        }


    }

    @Override
    public void attacks(Monster m1, Player p1) {
        int x = getBaseDamage();

        if (p1.getHealth() > 0) {

            crit(p1);

            if (sword) {
                m1.setHealth(m1.getHealth() - ( (p1.getBaseDamage() +p1.getStrength())  *2)  );
                System.out.println(p1.getName() + " attacks for " + ( (p1.getBaseDamage() +p1.getStrength())  *2) );
            } else {
                m1.setHealth(m1.getHealth() - (p1.getBaseDamage() +p1.getStrength()) );
                System.out.println(p1.getName() + " attacks for " + (p1.getBaseDamage() + p1.getStrength()) );
            }



            setBaseDamage(x);  // ties to crit(p1);

            System.out.println("Remaining health of: " +m1.getName() + " is " + m1.getHealth());

        } else {
            System.out.println("You are dead in Player attacks");
            System.out.println("game over in Player attacks");
            System.exit(0);
        }
        scanner.nextLine();

    }





    /*public void monsterAttacks (Monster m1, Player p1) {
        if (m1.getHealth() > 0) {
            System.out.println(m1.getName() + " attacks for " + m1.getDamage());
            p1.setHealth(p1.getHealth() - m1.getDamage());
            System.out.println("Remaining player health: " + p1.getHealth());
        } else {
            System.out.println("Monster is dead");
        }
        scanner.nextLine();

    } */

    /*public void flee (Player p1, Monster m1, boolean flee) {

        //Main main = new Main();


        if (p1.getAgility() > m1.getAgility()) {
            System.out.println("Successfully ran away!");
            flee = true; //gameMenu(p1,m1);


        } else {
            flee = false;
            System.out.println("Failed to run away");
            m1.attacks(m1,p1);
        }

    } */

    public void growth (Player p1) {

        switch (p1.getLevel() ) {
            case 2 -> {
                p1.setStrength(p1.getStrength() + 10);
                p1.setIntelligence(p1.getIntelligence() + 10);
                p1.setAgility(p1.getAgility() + 10);
            }
            case 3 -> {
                p1.setStrength(p1.getStrength() + 10);
                p1.setIntelligence(p1.getIntelligence() + 10);
                p1.setAgility(p1.getAgility() + 10);
            }
            case 4 -> {
                p1.setStrength(p1.getStrength() + 10);
                p1.setIntelligence(p1.getIntelligence() + 10);
                p1.setAgility(p1.getAgility() + 10);
            }
        }


    }


}
