package com.maksim.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //String playerName;

        Player p1 = new Player();

        p1.setAgility(100);
        p1.setHealth(100);
        p1.setStrength(10);
        p1.setIntelligence(10);
        p1.setBaseDamage(10);
        p1.setExp(0);
        p1.setLevel(1);




        Monster m1 = new Monster();

        m1.setAgility(50);
        m1.setHealth(30);
        m1.setDamage(6);
        m1.setExpYield(10);
        m1.setName("Monster 1");

        Monster m2 = new Monster();
        m2.setAgility(100);
        m2.setHealth(1);
        m2.setDamage(50);
        m2.setExpYield(50);
        m2.setName("Quick Strike");

        List <Monster> monsterList = new ArrayList<>();

        monsterList.add(m1);
        monsterList.add(m2);

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

        Main main = new Main();
        System.out.println("Choose which monster to fight");
        System.out.println(monsterList);

        do {

            switch (sc.nextLine()) {
                case "1" -> {
                    main.gameMenu(p1, m1);
                    monsterList.remove(m1);

                }
                case "2" -> {
                    main.gameMenu(p1, m2);
                    monsterList.remove(m2);
                }
            }
            p1.getStatus();

         } while (!monsterList.isEmpty());
        System.out.println("");

        System.out.println("You defeated game");





        /* TODO
        * --> Where is playerName?   // Player class
        * --> which file owns variable: playerName?  // Player class perhaps would be relevant
        * --> How can we make the code better? Move code into other classes and methods
        * --> Does playerName cause problems in the future?
        *
        * */


    }

    void gameMenu (Player p1, Monster m1) {
        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(m1);
        System.out.println("""
                1. Fight
                2. Status
                3. List of monsters
                4. Monster list
                5. Exit game
                """);


        do {

            switch (sc.nextLine()) {
                case "1" -> fightMenu(p1,m1);
                case "2" -> p1.getStatus();
                case "3" -> {
                    for (int i = 0; i < monsterList.size(); i++) {
                        System.out.println(monsterList.get(i));
                    }
                }
                case "4" -> System.out.println(monsterList);
                case "5" -> System.exit(0);

                default -> System.out.println("try again!");
            }
        }
        while (m1.getHealth() > 0);


    }

    public static void fightMenu (Player p1, Monster m1) {
        boolean monsterAlive = true;
        boolean playerAlive = true;

        do {

            System.out.println("inside fightMenu");
            System.out.println("""
                1. Attack
                2. Defend
                3. Flee
                4. See player stats
                5. See monster stats
                """);

            switch (sc.nextLine()) {
                case "1" -> p1.turnOrder(p1, m1);                               //p1.fight(p1, m1);
                case "2" -> p1.defend(m1, p1);                                         //System.out.println("Defend");
                case "3" -> p1.flee(p1, m1);                                                    //System.out.println("Flee");
                case "4" -> p1.getStatus();
                case "5" -> m1.monStatus();

                default -> System.out.println("try again");

            }
            if (m1.getHealth() <= 0) {
                monsterAlive = false;
            }
            if (p1.getHealth() <= 0) {
                playerAlive = false;
            }

        } while (monsterAlive && playerAlive);

        if (playerAlive) {
            System.out.println("you won");
        } else {
            System.out.println("you lost");
        }

    }

}