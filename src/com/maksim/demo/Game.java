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

    static DBConnection dbConnection = new DBConnection();
    static List <Monster> nextEnemyList = new ArrayList<>();



    public void menu () {

        dbConnection.open();
        dbConnection.createMonsterTable3();
        dbConnection.createTablePlayer();
        Shop shop = new Shop();

        Player p1 = new Player(0,
                0,
                0,
                50,
                0,
                0);



        p1.setAgility(50);
        p1.setHealth(100);
        p1.setStrength(10);
        p1.setIntelligence(1);
        p1.setBaseDamage(10);
        p1.setExp(0);
        p1.setLevel(1);
        p1.setAlive(true);



        Monster m1 = new Monster();

        m1.setAlive(true);
        m1.setAgility(40);
        m1.setHealth(30);
        m1.setMaxHealth(m1.getHealth());
        m1.setDamage(30);
        m1.setExpYield(100);
        m1.setName("1st Enemy");
        m1.setStamina(2);
        m1.setMaxStamina(m1.getStamina());
        m1.setInfo("Just your average enemy! Keep on attacking and it should go down");

        dbConnection.createMonster3(m1);

        Monster m2 = new Monster();

        m2.setAlive(true);
        m2.setAgility(80);
        m2.setHealth(60);
        m2.setMaxHealth(m2.getHealth());
        m2.setDamage(20);
        m2.setExpYield(120);
        m2.setName("Quick Strike");
        m2.setStamina(4);
        m2.setMaxStamina(m2.getStamina());
        m2.setSmart(true);
        m2.setCoward(false);
        m2.setInfo("Fast and smart, don't get careless");

        dbConnection.createMonster3(m2);

        Monster m3 = new Monster();

        m3.setAlive(true);
        m3.setAgility(110);
        m3.setHealth(1);
        m3.setMaxHealth(m3.getHealth());
        m3.setDamage(10);
        m3.setExpYield(190);
        m3.setCoward(true);
        m3.setName("Coward");
        m3.setStamina(5);
        m3.setMaxStamina(m3.getStamina());
        m3.setInfo("Will run away to avoid fighting, but can't keep himself from attacking a "+BLUE+"Defending"+RESET+" opponent..");

        dbConnection.createMonster3(m3);


        Monster m4 = new Monster();

        m4.setAlive(true);
        m4.setAgility(60);
        m4.setHealth(100);
        m4.setMaxHealth(m4.getHealth());
        m4.setDamage(45);
        m4.setExpYield(230);
        m4.setCoward(false);
        m4.setName("Devout");
        m4.setStamina(4);
        m4.setMaxStamina(m4.getStamina());
        m4.setInfo("...");

        Monster m5 = new Monster();

        m5.setAlive(true);
        m5.setAgility(70);
        m5.setHealth(500);
        m5.setMaxHealth(m5.getHealth());
        m5.setDamage(30);
        m5.setExpYield(300);
        m5.setCoward(false);
        m5.setName("Second in Command");
        m5.setStamina(5);
        m5.setMaxStamina(m5.getStamina());
        m5.setInfo("Can take a lot of hits");

        Monster m6 = new Monster();

        m6.setAlive(true);
        m6.setAgility(105);
        m6.setHealth(1000);
        m6.setMaxHealth(m6.getHealth());
        m6.setDamage(70);
        m6.setExpYield(1030);
        m6.setCoward(false);
        m6.setName("Dark False");
        m6.setStamina(5);
        m6.setMaxStamina(m6.getStamina());
        m6.setSmart(true);
        m6.setInfo("The most powerful enemy in the game. Good luck!");



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

        System.out.println("Welcome to game adventure");   // green text
        System.out.println("Input your name? ");
        p1.setName(sc.nextLine());

        dbConnection.createPlayer(p1);

        System.out.println("Your name is " + p1.getName());


        System.out.printf("Hello, %s, ", p1.getName()); // format
        System.out.println();
        System.out.println("This is your current status: ");
        p1.getStatus();
        System.out.println("");

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
            System.out.println("Remaining enemies:");

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
            p1.getStatus();
            System.out.println("");

        } while (!enemyList.isEmpty());
        System.out.println("");
        System.out.println("The first enemies have been dealt with!");
        System.out.println("Got 1000 exp!");
        p1.setExp(p1.getExp() + 1000);
        sc.nextLine();
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

            System.out.println("Remaining enemies:");

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


        System.out.println("");
        System.out.println("All enemies dead");
        System.out.println("You won");
        sc.nextLine();

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
        randomMonster.setName(WHITE_BRIGHT+"Random enemy #" + random.nextInt(1,999)+RESET);
        randomMonster.setStamina(random.nextInt(1,5));
        randomMonster.setMaxStamina(randomMonster.getStamina());

        randomMonster.setExpYield(randomMonster.getDamage() + randomMonster.getHealth());



        boolean isPlaying = true;


            do {

                System.out.println("inside random gameMenu");
                System.out.println("Fighting: " + WHITE_BRIGHT + randomMonster.getName() + RESET);
                System.out.println("""
                
                1. Fight
                2. Status
                3. Current monster Status
                4. Exit to random enemy menu
                
                """);

                switch (sc.nextLine()) {
                    case "1" -> fightMenu(p1,randomMonster);
                    case "2" -> p1.getStatus();
                    case "3" -> randomMonster.monStatus();
                    case "4" -> isPlaying= false;

                    default -> System.out.println("Try again!");
                }

                if (randomMonster.getHealth() <= 0) {
                    enemyList.remove(randomMonster);
                    isPlaying=false;
                }
            }

            while (isPlaying);

    }

    public void randomMonsterMenuNext (Player p1) {
        boolean inMenu = true;

        do {
            System.out.println("Fight an enemy?");
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
        randomMonster.setAgility(random.nextInt(10,100));
        randomMonster.setHealth(random.nextInt(50,300));
        randomMonster.setMaxHealth(randomMonster.getHealth());
        randomMonster.setDamage(random.nextInt(10,100));
        randomMonster.setName("Random enemy #" + random.nextInt(1,999));
        randomMonster.setStamina(random.nextInt(5,10));
        randomMonster.setMaxStamina(randomMonster.getStamina());
        randomMonster.setExpYield(randomMonster.getDamage() + randomMonster.getHealth());
        randomMonster.setInfo("A random enemy");

        boolean isPlaying = true;


        do {

            System.out.println("Fighting: " + WHITE_BRIGHT + randomMonster.getName() + RESET);
            System.out.println("""
                
                1. Fight
                2. Status
                3. Current monster Status
                4. Exit to random enemy menu
                
                """);

            switch (sc.nextLine()) {
                case "1" -> fightMenu(p1,randomMonster);
                case "2" -> p1.getStatus();
                case "3" -> randomMonster.monStatus();

                case "4" -> isPlaying= false;

                default -> System.out.println("Try again!");
            }

            if (randomMonster.getHealth() <= 0) {
                enemyList.remove(randomMonster);
                isPlaying=false;
            }
        }

        while ( isPlaying);

    }

    public void gameMenu (Player p1, Monster m1) {
        List<Monster> monsterList2 = new ArrayList<>();
        monsterList2.add(m1);
        boolean isPlaying = true;

        if (m1.getAlive()){

            do {

                System.out.println("");
                System.out.println("Fighting: " + WHITE_BRIGHT + m1.getName() + RESET);
                System.out.println("""
                
                1. Fight
                2. Status
                3. Current enemy status
                4. Exit to enemy menu
                
                """);

                switch (sc.nextLine()) {
                    case "1" -> fightMenu(p1,m1);
                    case "2" -> p1.getStatus();
                    case "3" -> m1.monStatus();
                    case "4" -> isPlaying= false;

                    default -> System.out.println("Try again!");
                }

                if (m1.getHealth() <= 0) {
                    enemyList.remove(m1);
                    if (enemyList.isEmpty()) {
                        nextEnemyList.remove(m1);
                    }
                    isPlaying=false;

                }
            }

            while (isPlaying);


        } else {

            System.out.println(WHITE_BRIGHT + m1.getName() + RESET + " is dead");
            sc.nextLine();
        }

    }

    public void fightMenu (Player p1, Monster m1) {


        do {

            p1.setFlee(false);
            m1.setFlee(false);
            System.out.println("");
            System.out.println("Battling against " + WHITE_BRIGHT + m1.getName() + RESET);
            System.out.println(RED + "1: Attack" + RESET);
            System.out.println(BLUE+ "2: Defend" + RESET);
            System.out.println(YELLOW + "3: Flee" + RESET);

            System.out.println("""
                4. See player stats
                5. See enemy stats
                """);

            switch (sc.nextLine()) {
                case "1" -> p1.turnOrder(p1, m1);
                case "2" -> {p1.setDefend(true); p1.defend(m1,p1); }
                case "3" -> p1.fleeing(p1,m1);
                case "4" -> p1.getStatus();
                case "5" -> m1.monStatus();

                default -> System.out.println("try again");

            }

            if (m1.getHealth() <= 0) {
                m1.setAlive(false);
                p1.setEnemiesDefeated(p1.getEnemiesDefeated() + 1);
                dbConnection.updateEnemiesDefeated(p1);
                System.out.println("You defeated " + WHITE_BRIGHT + m1.getName() + RESET);
                sc.nextLine();
            }

            if (p1.getHealth() <= 0) {
                p1.setAlive(false);
            }



        } while (m1.getAlive() && p1.getAlive() && !p1.getFlee() && !m1.getFlee());



        if (!m1.getAlive() && p1.getAlive()) {
            System.out.println("You earned " + PURPLE + m1.getExpYield() +  RESET + " experience!");
            p1.setExp(p1.getExp() + m1.getExpYield());
            dbConnection.updateExp(p1);
            System.out.println("");
            sc.nextLine();
        }

        if (!p1.getAlive()){

            gameOver(p1);
        }

    }

    public void gameOver (Player p1) {

        System.out.println("You lost");
        System.out.println();

        if (p1.getExp() > 0) {
            p1.setExp(0);
            System.out.println("You used your exp to reawaken");
            p1.setFlee(true);
            p1.setAlive(true);
            p1.setHealth(100);

        } else {
            result.writeResult(p1);
            System.out.println("Game Over");
            System.exit(0);
        }


    }


}
