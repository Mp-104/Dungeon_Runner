package com.maksim.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* TODO
    implement intelligence ( crit damage modifier) G - Gjort !
    Shop VG
    Weapons? VG - Delvis, testat
    Colours  VG
    Tests -> enhanced Tests
* */

public class Main {

    //static boolean isFighting;
    static Scanner sc = new Scanner(System.in);
    static List <Monster> monsterList = new ArrayList<>();

    public static void main(String[] args) {

        //String playerName;

        Player p1 = new Player(0,
                                0,
                                0,
                                50,
                                0,
                                0);

        p1.takeDamage(5);

        System.out.println(p1.getHealth());

        System.out.println("---Debugging---");
        System.out.println();
        System.out.println("---Debugging---");

        p1.setAgility(100);
        p1.setHealth(1000);
        p1.setStrength(100);
        p1.setIntelligence(00);
        p1.setBaseDamage(10);
        p1.setExp(0);
        p1.setLevel(1);
        p1.setAlive(true);
        p1.setSword(true);
        p1.setShield(true);




        Monster m1 = new Monster();

        m1.setAlive(true);
        m1.setAgility(30);
        m1.setHealth(20);
        m1.setDamage(6);
        m1.setExpYield(100);
        m1.setName("Monster 1");
        m1.setStamina(2);

        Monster m2 = new Monster();

        m2.setAlive(true);
        m2.setAgility(100);
        m2.setHealth(1000);
        m2.setDamage(500);
        m2.setExpYield(120);
        m2.setName("Quick Strike");
        m2.setStamina(3);

        Monster m3 = new Monster();

        m3.setAlive(true);
        m3.setAgility(45);
        m3.setHealth(10);
        m3.setDamage(3);
        m3.setExpYield(190);
        m3.setCoward(true);
        m3.setName("Coward");
        m3.setStamina(5);


        //List <Monster> monsterList = new ArrayList<>();

        monsterList.add(m1);
        monsterList.add(m2);
        monsterList.add(m3);

        //System.out.println("p1.speed(): " + p1.speed());  // ??

        //p1.fight(m1,p1);



        //p1.setName(sc.nextLine());

        System.out.println("welcome adventure");   // green text
        System.out.println("what is your name? ");
        //playerName = sc.nextLine();
        p1.setName(sc.nextLine());


        //System.out.println("ah, your name is " + playerName);

        System.out.println("ah, your name is " + p1.getName());

        //menu
        /*System.out.println("hello \nworld0");
        System.out.println("");
        System.out.println("hello1");
        System.out.println("world1");
        System.out.println("""
                hello2
                
                world2
                """); */

        // souf
        System.out.printf("hello %s, ", p1.getName()); // format
        System.out.println();
        System.out.println("This is how strong you currently are: ");
        p1.getStatus();
        System.out.println();
        System.out.println();



        System.out.println("0. Debugging experience");


        do {
            System.out.println("Choose which monster to fight");
            System.out.println("1: " + m1.getName());
            System.out.println("2: " + m2.getName());
            System.out.println("3: " + m3.getName());
            System.out.println("Remaining monsters:");

            for (int i = 0; i < monsterList.size(); i++) {
                System.out.println(monsterList.get(i).getName() );
            }


            switch (sc.nextLine()) {
                case "1" -> {
                    gameMenu(p1, m1);
                    //monsterList.remove(m1);

                }
                case "2" -> {
                    gameMenu(p1, m2);
                    //monsterList.remove(m2);
                }
                case "3" -> gameMenu(p1, m3);

                case "0" -> p1.calculateExpToLvl(125);                       //p1.debugReceiveExperience(125,p1);


            }
            p1.getStatus();

         } while (!monsterList.isEmpty());
        System.out.println("");
        System.out.println("All monsters have been unalived!");

        System.out.println("You defeated game");





        /* TODO
        * --> Where is playerName?   // Player class
        * --> which file owns variable: playerName?  // Player class perhaps would be relevant
        * --> How can we make the code better? Move code into other classes and methods
        * --> Does playerName cause problems in the future?
        *
        * */


    }

    public static void gameMenu (Player p1, Monster m1) {
        List<Monster> monsterList2 = new ArrayList<>();
        monsterList2.add(m1);
        boolean isPlaying = true;

        if (m1.getAlive()){

            do {

                System.out.println("inside gameMenu");
                System.out.println("""
                
                1. Fight
                2. Status
                3. Current monster
                4. Current monster
                5. Exit to monster menu
                
                """);

                switch (sc.nextLine()) {
                    case "1" -> fightMenu(p1,m1);
                    case "2" -> p1.getStatus();
                    case "3" -> {
                        for (int i = 0; i < monsterList2.size(); i++) {
                            System.out.println(monsterList2.get(i));
                        }
                    }
                    case "4" -> System.out.println(monsterList2);
                    case "5" -> isPlaying= false;        //System.exit(0);

                    default -> System.out.println("try again!");
                }
                //System.out.println("monsterList.get(0): " );
                if (m1.getHealth() <= 0) {
                    monsterList.remove(m1);
                    isPlaying=false;
                }
            }

            while ( /*m1.getHealth() > 0 || */isPlaying);


        } else {

            System.out.println(m1.getName() + " is dead");
            sc.nextLine();
        }




    }

    public static void fightMenu (Player p1, Monster m1) {
        boolean playerAlive = true;


        do {

            p1.setFlee(false);
            m1.setFlee(false);
            System.out.println("");
            System.out.println("inside fightMenu");
            System.out.println("Battling against " + m1.getName());
            System.out.println("""
                1. Attack
                2. Defend
                3. Flee
                4. See player stats
                5. See monster stats
                """);

            switch (sc.nextLine()) {
                case "1" -> p1.turnOrder(p1, m1);                               //p1.fight(p1, m1);
                case "2" -> {p1.setDefend(true); p1.defend(m1,p1);   }   //p1.defend(m1, p1);                                         //System.out.println("Defend");
                case "3" -> p1.fleeing(p1,m1);      //p1.flee(p1,m1);
                /*{ if (p1.getAgility() > m1.getAgility()) {
                    flee = true;
                    System.out.println("Ran away successfully!");
                } else {
                    System.out.println("Monster is faster");
                    System.out.println("Failed to run away");
                    m1.attacks(m1,p1);
                }
                }   */         //p1.flee(p1, m1, flee);                                                    //System.out.println("Flee");
                case "4" -> p1.getStatus();
                case "5" -> m1.monStatus();

                default -> System.out.println("try again");

            }

            if (m1.getHealth() <= 0) {
                //monsterAlive = false;
                m1.setAlive(false);
                System.out.println("you defeated " + m1.getName());
                System.out.println("");
                sc.nextLine();
            }

            if (p1.getHealth() <= 0) {
                //playerAlive = false;
                p1.setAlive(false);
            }



        } while (m1.getAlive() && p1.getAlive() && !p1.getFlee() && !m1.getFlee());



        if (!m1.getAlive() && p1.getAlive()) {
            System.out.println("you won");
            System.out.println("You earned " + m1.getExpYield() + " experience!");
            //p1.setExp(p1.getExp() + m1.getExpYield());
            p1.calculateExpToLvl(m1.getExpYield());
            p1.growth(p1);
            System.out.println("");
            sc.nextLine();
        }

        if (!p1.getAlive()){
            System.out.println("you lost");
            System.out.println("Game over");
            System.exit(0);
        }

    }

    // public static void debugReceiveExperience (int amountOfExp, Player p1) {

        /* TODO
               100 -> 1
               1000 -> 10
               10 000 -> 100
               100 000 -> 1000   använd modulus för att optimera kod, för många loop iterationer med höga tal

        *


        // 100 exp == +1 level, 1000 exp== +10 level, 1005 exp?
        // amountOfExp = 100
        /*for (int i = amountOfExp; i > 0 ; i--) {
            System.out.println(i);
            p1.setExp(p1.getExp() + 1);

            if (p1.getExp() == 100) {
                p1.setLevel(p1.getLevel() + 1);
                p1.setExp(0);
            }

        } */

        /*System.out.println("How much exp?");
        System.out.println(p1.getExp());
        System.out.println("Player level");
        System.out.println(p1.getLevel()); */

    }

