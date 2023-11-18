package com.maksim.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import static com.maksim.demo.Colours.*;

public class Game {
    Result result = new Result();
    static Scanner sc = new Scanner(System.in);
    static List <Monster> enemyList = new ArrayList<>();

    static List <Monster> nextEnemyList = new ArrayList<>();



    public void menu () {

        Shop shop = new Shop();

        Player p1 = new Player(0,
                0,
                0,
                50,
                0,
                0);



        System.out.println(p1.getHealth());

        System.out.println("---Debugging---");
        System.out.println();
        System.out.println("---Debugging---");

        p1.setAgility(10);
        p1.setHealth(2900);
        p1.setStrength(100);
        p1.setIntelligence(500);
        p1.setBaseDamage(1);
        p1.setExp(10000);
        p1.setLevel(100);
        p1.setAlive(true);
        //p1.setDefence(21);
        //p1.setSword(true);
        //p1.setShield(true);




        Monster m1 = new Monster();

        m1.setAlive(true);
        m1.setAgility(300);
        m1.setHealth(300);
        m1.setMaxHealth(1);
        m1.setDamage(6);
        m1.setExpYield(10000);
        m1.setName("Monster 1");
        m1.setStamina(2);
        m1.setMaxStamina(2);

        Monster m2 = new Monster();

        m2.setAlive(true);
        m2.setAgility(1000);
        m2.setHealth(9);
        m2.setMaxHealth(107);
        m2.setDamage(5);
        m2.setExpYield(120);
        m2.setName("Quick Strike");
        m2.setStamina(3);
        m2.setMaxStamina(3);
        m2.setSmart(true);
        m2.setCoward(false);

        Monster m3 = new Monster();

        m3.setAlive(true);
        m3.setAgility(150);
        m3.setHealth(1);
        m3.setMaxHealth(1);
        m3.setDamage(30);
        m3.setExpYield(190);
        m3.setCoward(true);
        m3.setName("Coward");
        m3.setStamina(5);
        m3.setMaxStamina(5);

        Monster m4 = new Monster();

        m4.setAlive(true);
        m4.setAgility(150);
        m4.setHealth(1);
        m4.setMaxHealth(1);
        m4.setDamage(30);
        m4.setExpYield(190);
        m4.setCoward(false);
        m4.setName("Number 1");
        m4.setStamina(5);
        m4.setMaxStamina(5);

        Monster m5 = new Monster();

        m5.setAlive(true);
        m5.setAgility(150);
        m5.setHealth(1);
        m5.setMaxHealth(1);
        m5.setDamage(30);
        m5.setExpYield(190);
        m5.setCoward(false);
        m5.setName("Number 2");
        m5.setStamina(5);
        m5.setMaxStamina(5);

        Monster m6 = new Monster();

        m6.setAlive(true);
        m6.setAgility(150);
        m6.setHealth(1);
        m6.setMaxHealth(1);
        m6.setDamage(30);
        m6.setExpYield(190);
        m6.setCoward(false);
        m6.setName("Number 3");
        m6.setStamina(5);
        m6.setMaxStamina(5);



        //List <Monster> monsterList = new ArrayList<>();

        enemyList.add(m1);
        enemyList.add(m2);
        enemyList.add(m3);

        nextEnemyList.add(m4);
        nextEnemyList.add(m5);
        nextEnemyList.add(m6);

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






        do {
            System.out.println("Choose which enemy to fight");

            System.out.println("1: " + m1.getName());
            System.out.println("2: " + m2.getName());
            System.out.println("3: " + m3.getName());
            System.out.println("4: Random enemies");
            System.out.println("");
            System.out.println("0: Shop");
            System.out.println("9. Exit game");
            System.out.println("");
            System.out.println("Remaining monsters:");

            for (int i = 0; i < enemyList.size(); i++) {
                System.out.println(enemyList.get(i).getName() );
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
                case "4" -> randomMonsterMenu(p1);
                case "0" -> shop.menu(p1);

                case "9" -> {
                    result.writeResult(p1);
                    System.exit(0);
                }
                default -> System.out.println("Try again");


            }
            p1.getStatus();  // TODO - Remove later, used for testing

        } while (!enemyList.isEmpty());
        System.out.println("");
        System.out.println("The first enemies have been dealt with!");
        System.out.println("");
        System.out.println("New enemies approaching");
        System.out.println("");

        System.out.println("Welcome to The Next Level");
        System.out.println("");

        sc.nextLine();



        do {


            System.out.println("Choose which enemy to fight");
            System.out.println("1: " + m4.getName());
            System.out.println("2: " + m5.getName());
            System.out.println("3: " + m6.getName());
            System.out.println("4: Random enemies");
            System.out.println("");
            System.out.println("0: Shop");
            System.out.println("9. Exit game");
            System.out.println("");

            System.out.println("Remaining monsters:");

            for (int i = 0; i < nextEnemyList.size(); i++) {
                System.out.println(nextEnemyList.get(i).getName() );
            }


            switch (sc.nextLine()) {
                case "1" -> gameMenu(p1, m4);
                case "2" -> gameMenu(p1, m5);
                case "3" -> gameMenu(p1, m6);
                case "4" -> randomMonsterMenuNext(p1);
                case "0" -> shop.menu(p1);

                case "9" -> {
                    result.writeResult(p1);
                    System.exit(0);
                }
                default -> System.out.println("Try again");


            }
            p1.getStatus();


            } while (!nextEnemyList.isEmpty());

        System.out.println("All enemies dead");
        System.out.println("You won");

        System.out.println("");
        System.out.println("Assume role of supreme leader?");
        System.out.println("1: Yes");

        if (sc.nextLine().equals("1")) {
            System.out.println("You became supreme leader!");
        } else {
            System.out.println("Too bad");
        }


        Result result = new Result();
        result.writeResult(p1);

    }

    public void randomMonsterMenu (Player p1) {
        boolean inMenu = true;

        do {
            System.out.println("Inside randomMenu");
            System.out.println("1: Fight a random enemy");
            System.out.println("2: Exit menu");

            switch (sc.nextLine()) {
                case "1" -> randomGameMenu(p1);
                case "2" -> inMenu = false;
                default -> System.out.println("Try again");
            }

        } while (inMenu);

    }

    public void randomGameMenu (Player p1) {

        Random random = new Random();
        Monster randomMonster = new Monster();

        randomMonster.setAlive(true);
        randomMonster.setAgility(random.nextInt(1,10));
        randomMonster.setHealth(random.nextInt(1,10));
        randomMonster.setMaxHealth(randomMonster.getHealth());
        randomMonster.setDamage(random.nextInt(1,10));
        randomMonster.setName("Random enemy #" + random.nextInt(1,999));
        randomMonster.setStamina(random.nextInt(1,5));
        randomMonster.setMaxStamina(randomMonster.getStamina());

        randomMonster.setExpYield(randomMonster.getDamage() + randomMonster.getHealth());


        //List<Monster> monsterList2 = new ArrayList<>();
        //monsterList2.add(randomMonster);
        boolean isPlaying = true;


            do {

                System.out.println("inside random gameMenu");
                System.out.println("Fighting: " + randomMonster.getName());
                System.out.println("""
                
                1. Fight
                2. Status
                3. Current monster Status
                4. Exit to random enemy menu
                
                """);

                switch (sc.nextLine()) {
                    case "1" -> fightMenu(p1,randomMonster);
                    case "2" -> p1.getStatus();
                    case "3" -> { randomMonster.monStatus();
                        /*for (int i = 0; i < monsterList2.size(); i++) {
                            System.out.println(monsterList2.get(i));
                        } */
                    }
                    //case "4" -> System.out.println(monsterList2);
                    case "4" -> isPlaying= false;        //System.exit(0);

                    default -> System.out.println("Try again!");
                }
                //System.out.println("monsterList.get(0): " );
                if (randomMonster.getHealth() <= 0) {
                    enemyList.remove(randomMonster);
                    isPlaying=false;
                }
            }

            while ( /*m1.getHealth() > 0 || */isPlaying);

    }

    public void randomMonsterMenuNext (Player p1) {
        boolean inMenu = true;

        do {
            System.out.println("Inside randomMenu");
            System.out.println("1: Fight a random enemy");
            System.out.println("2: Exit menu");

            switch (sc.nextLine()) {
                case "1" -> randomGameMenuNext(p1);
                case "2" -> inMenu = false;
                default -> System.out.println("Try again");
            }

        } while (inMenu);

    }


    public void randomGameMenuNext (Player p1) {

        Random random = new Random();
        Monster randomMonster = new Monster();

        randomMonster.setAlive(true);
        randomMonster.setAgility(random.nextInt(100,1000));
        randomMonster.setHealth(random.nextInt(100,1000));
        randomMonster.setMaxHealth(randomMonster.getHealth());
        randomMonster.setDamage(random.nextInt(100,1000));
        randomMonster.setName("Random enemy #" + random.nextInt(1,999));
        randomMonster.setStamina(random.nextInt(5,10));
        randomMonster.setMaxStamina(randomMonster.getStamina());

        randomMonster.setExpYield(randomMonster.getDamage() + randomMonster.getHealth());


        //List<Monster> monsterList2 = new ArrayList<>();
        //monsterList2.add(randomMonster);
        boolean isPlaying = true;


        do {

            System.out.println("inside random gameMenu");
            System.out.println("Fighting: " + randomMonster.getName());
            System.out.println("""
                
                1. Fight
                2. Status
                3. Current monster Status
                4. Exit to random enemy menu
                
                """);

            switch (sc.nextLine()) {
                case "1" -> fightMenu(p1,randomMonster);
                case "2" -> p1.getStatus();
                case "3" -> { randomMonster.monStatus();
                        /*for (int i = 0; i < monsterList2.size(); i++) {
                            System.out.println(monsterList2.get(i));
                        } */
                }
                //case "4" -> System.out.println(monsterList2);
                case "4" -> isPlaying= false;        //System.exit(0);

                default -> System.out.println("Try again!");
            }
            //System.out.println("monsterList.get(0): " );
            if (randomMonster.getHealth() <= 0) {
                enemyList.remove(randomMonster);
                isPlaying=false;
            }
        }

        while ( /*m1.getHealth() > 0 || */isPlaying);

    }

    public void gameMenu (Player p1, Monster m1) {
        List<Monster> monsterList2 = new ArrayList<>();
        monsterList2.add(m1);
        boolean isPlaying = true;

        if (m1.getAlive()){

            do {

                System.out.println("inside gameMenu");
                System.out.println("""
                
                1. Fight
                2. Status
                3. Current monster status
                4. Exit to monster menu
                
                """);

                switch (sc.nextLine()) {
                    case "1" -> fightMenu(p1,m1);
                    case "2" -> p1.getStatus();
                    case "3" -> { m1.monStatus();
                        /*for (int i = 0; i < monsterList2.size(); i++) {
                            System.out.println(monsterList2.get(i));
                        } */
                    }
                    case "4" -> isPlaying= false;        //System.exit(0);

                    default -> System.out.println("Try again!");
                }
                //System.out.println("monsterList.get(0): " );
                if (m1.getHealth() <= 0) {
                    enemyList.remove(m1);
                    if (enemyList.isEmpty()) {
                        nextEnemyList.remove(m1);
                    }
                    isPlaying=false;

                }
            }

            while ( /*m1.getHealth() > 0 || */isPlaying);


        } else {

            System.out.println(m1.getName() + " is dead");
            sc.nextLine();
        }

    }

    public void fightMenu (Player p1, Monster m1) {


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
                p1.setEnemiesDefeated(p1.getEnemiesDefeated() + 1);
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
            p1.setExp(p1.getExp() + m1.getExpYield());
            //p1.calculateExpToLvl(m1.getExpYield());
            //p1.growth(p1);
            System.out.println("");
            sc.nextLine();
        }

        if (!p1.getAlive()){

            gameOver(p1);
            /*System.out.println("you lost");
            System.out.println("Game over");

            Result result = new Result();
            result.myMethod(p1);

            System.exit(0); */


        }

    }

    public void gameOver (Player p1) {

        System.out.println("you lost");
        System.out.println();

        if (p1.getExp() > 0) {
            p1.setExp(0);
            System.out.println("You used your exp to reawaken");
            p1.setFlee(true);
            p1.setAlive(true);
            p1.setHealth(1);

        } else {
            result.writeResult(p1);
            System.out.println("game over");
            System.exit(0);
        }


        //Result result = new Result();
        //result.writeResult(p1);

        //System.exit(0);

    }


}
