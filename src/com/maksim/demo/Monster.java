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

    private boolean flee;

    private boolean alive;

    private int stamina;

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
    public boolean getAlive () {
        return alive;
    }

    public void setAlive (boolean alive) {
        this.alive = alive;
    }

    public int getStamina () {
        return stamina;
    }

    public void setStamina (int stamina) {
        this.stamina = stamina;
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




    int x;
    @Override
    public void attacks(Monster m1, Player p1) {



        System.out.println("x: " + x);
        System.out.println(name+ "'s stamina in m1.attacks: " + stamina);


        if (m1.getHealth() > 0 && stamina > 0) {
            outmatched(p1,m1);

            if (m1.getDamage() >= p1.getHealth() && coward) {
                System.out.println(name + " sees an opportunity");
                coward = false;
            } else {
                //outmatched(p1,m1);
            }


            /*if (m1.getHealth() <= p1.getBaseDamage() && !coward) {
                System.out.println(name + " is outmatched");
                coward = true;
            } */

            if (stamina == 1) {
                System.out.println(name + " is getting tired, it seems in m1.attacks");
            }

            if (coward && !p1.getDefend()) {

                fleeing (p1,m1);
            }else {


                    System.out.println(m1.getName() + " attacks for " + m1.getDamage());
                    p1.setHealth(p1.getHealth() - m1.getDamage());
                    //p1.setHealth((int) (p1.getHealth() - (m1.getDamage() / (p1.getDefence() * 0.1) )));
                    //System.out.println("damage calc" + (m1.getDamage() / (p1.getDefence() * 0.1)  )    );

                    System.out.println("Remaining player health: " + p1.getHealth());
                    stamina -= 1 ;
                    x += 1;

                System.out.println(x);
                }

            } else {


            if (stamina == 0) {
                exhausted();

                /*System.out.println(name + " is exhausted");
                System.out.println(name + " has to recover");
                stamina += x;
                x = 0;*/

            } else {
                System.out.println("Monster is dead");
            }

            }


        scanner.nextLine();

    }

    public void exhausted () {
        System.out.println(name + " is exhausted");
        System.out.println(name + " has to recover");
        stamina += x;
        x = 0;
        setHealth(getHealth() + 10);
        System.out.println(name + " recovered 10 health");
    }

    public void outmatched (Player p1, Monster m1) {



        if (m1.getHealth() > p1.getBaseDamage() ) {
            System.out.println(name + "  not coward");
            coward = false;
        } else {
            coward = true;
            System.out.println("is coward");
        }

    }


    @Override
    public void fleeing(Player p1, Monster m1) {
            //System.out.println(name + "'s stamina in fleeing: " + stamina);
            /*if (stamina == 1) {
                System.out.println(name + " is getting tired, it seems in fleeing");
            } */

            if (stamina > 0) {   // stamina should probably not be a factor in fleeing...
                if (m1.coward) {
                    System.out.println("monster is a coward (in fleeing)");
                    System.out.println("monster tries to run away (in fleeing)");
                    if (m1.getAgility() >= p1.getAgility()) {
                        System.out.println("monster ran away successfully (in fleeing)");
                        //stamina -=1;  // REMOVE ?
                        x += 1;
                        flee = true;

                    } else {
                        System.out.println("monster is too slow and failed to run away");
                        //stamina -=1;
                        x +=1;
                        /*exhausted();   // not working
                        p1.attacks(m1, p1);  // not working
                        System.out.println("is this working??");  // not working*/
                        flee = false;



                        //p1.attacks(m1,p1);
                    }
                }

            } else {
                    System.out.println("monster is too tired to run away");
                    exhausted();
                    flee = false;
                //p1.attacks(m1,p1);

            }

    }

}
