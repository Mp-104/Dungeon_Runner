package com.maksim.demo;

import java.util.Scanner;
import static com.maksim.demo.Colours.*;
import static com.maksim.demo.Game.dbConnection;

public class Shop {

    Scanner scanner = new Scanner(System.in);
    Weapon weapon = new Weapon();

    void menu (Player p1) {
        boolean inShop = true;

        if (!p1.getSword()) {

            do {
                System.out.println("");
                System.out.println("Welcome to shop!");
                System.out.println("1: Cola - " + PURPLE+ 5 + RESET+ " exp");
                System.out.println("2: Burger - "+PURPLE + 10 +RESET +" exp");
                System.out.println("3: Sword - " +PURPLE+20+RESET+ " exp");
                System.out.println("4: Shield - "+ PURPLE+"10 "+RESET + " exp");
                System.out.println("5: Level up - " + PURPLE+(100 + (p1.getLevel() * p1.getLevel() ) -1) + RESET+ " exp");
                System.out.println("(Tip: Having Sword and Shield will allow you to do a counterattack after a successful Defend!)");
                System.out.println("");
                System.out.println("0: Exit Shop");
                System.out.println("Available exp: " + PURPLE+ p1.getExp()+RESET);



                switch (scanner.nextLine()) {
                    case "1" -> buyCola(p1);
                    case "2" -> buyBurger(p1);
                    case "3" -> buySword(p1);
                    case "4" -> buyShield(p1);
                    case "5" -> buyLevel(p1);
                    case "0" -> inShop = false;
                    default -> System.out.println("try again");

                }

            } while (inShop);

        } else {

            do {
                System.out.println("Welcome to shop!");
                System.out.println("1: Cola - " + PURPLE+ 5 + RESET+ " exp");
                System.out.println("2: Burger - "+PURPLE + 10 + RESET+" exp");
                System.out.println("3: Upgrade to laser sword - " +PURPLE+200+RESET+ " exp");
                System.out.println("4: Shield - "+ PURPLE+10 +RESET + " exp");
                System.out.println("5: Level up - " + PURPLE+(100 + (p1.getLevel() * p1.getLevel() ) -1) + RESET+ " exp");
                System.out.println("(Tip: Having Sword and Shield will allow you to do a counterattack after a successful Defend!)");
                System.out.println("");
                System.out.println("0: Exit Shop");
                System.out.println("Available exp: " + PURPLE+ p1.getExp()+RESET);



                switch (scanner.nextLine()) {
                    case "1" -> buyCola(p1);
                    case "2" -> buyBurger(p1);
                    case "3" -> buyLaserSword(p1);
                    case "4" -> buyShield(p1);
                    case "5" -> buyLevel(p1);
                    case "0" -> inShop = false;
                    default -> System.out.println("try again");

                }

            } while (inShop && p1.getSword());

        }

    }

    void spendCurrency (Player p1, int cost) {
        p1.setExp(p1.getExp()- cost );
        dbConnection.updateExp(p1);

    }

    void buyLevel (Player p1) {
        boolean pondering = true;

        System.out.println("Level up?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        do {
            switch (scanner.nextLine()) {
                case "1" -> {
                    if (p1.getExp() >= 100 + (p1.getLevel() * p1.getLevel()) - 1   ) {
                        spendCurrency(p1, (100 + (p1.getLevel() * p1.getLevel()) -1));
                        System.out.println("You levelled up!");
                        p1.growth();
                        dbConnection.updateLevel(p1);
                        dbConnection.updateStrength(p1);
                        dbConnection.updateIntelligence(p1);
                        dbConnection.updateAgility(p1);
                        pondering = false;
                    } else {
                        System.out.println("not enough exp");
                        pondering = false;
                    }
                }
                case "2" -> {
                    System.out.println("declined to level up");
                    pondering = false;
                }

            }


        } while (pondering);
    }

    void buyBurger (Player p1) {
        boolean pondering = true;

        System.out.println("Buy a burger?");
        System.out.println("1: Yes");
        System.out.println("2: no");

        do {
            switch (scanner.nextLine()) {
                case "1" -> {
                    if (p1.getExp() >= 10) {
                        p1.setHealth(p1.getHealth() + 50 );
                        dbConnection.updateHealth(p1);
                        spendCurrency(p1,10);
                        System.out.println("You ate burger!");
                        System.out.println("Recovered 50 health");
                        pondering = false;

                    } else {
                        System.out.println("Not enough currency (exp)");
                        pondering = false;
                    }
                }

                case "2" -> {
                    System.out.println("No burger?");
                    pondering = false;
                }

            }

        } while (pondering);


    }

    void buyCola (Player p1) {
        boolean pondering = true;

        System.out.println("Buy a cola?");
        System.out.println("1: Yes");
        System.out.println("2: no");

        do {
            switch (scanner.nextLine()) {
                case "1" -> {
                    if (p1.getExp() >= 5) {
                        p1.setHealth(p1.getHealth() + 20 );  // TODO - Set max HP, or can recover health indefinitely
                        dbConnection.updateHealth(p1);
                        spendCurrency(p1,5);
                        System.out.println("You drank cola!");
                        System.out.println("Recovered 20 health");
                        pondering = false;

                    } else {
                        System.out.println("Not enough currency (exp)");
                        pondering = false;
                    }
                }

                case "2" -> {
                    System.out.println("No cola?");
                    pondering = false;
                }

            }

        } while (pondering);


    }


    void buySword(Player p1) {
        boolean pondering = true;

        if (!p1.getSword()) {
            System.out.println("Buy a sword?");
            System.out.println("1: Yes!");
            System.out.println("2: no.");

            do {
                switch (scanner.nextLine()) {
                    case "1" -> {
                        if (p1.getExp() >= 20) {
                            //p1.setSword(true);
                            spendCurrency(p1,20);
                            System.out.println("You bought a sword!");

                            weapon.sword(p1);
                            pondering = false;

                        } else {
                            System.out.println("Not enough currency (exp)");
                            pondering = false;
                        }
                    }

                    case "2" -> {
                        System.out.println("Too bad");
                        pondering = false;
                    }

                }

            } while (pondering);

        } else {
            System.out.println("You already have a sword");

        }


    }
    boolean laserSword;
    void buyLaserSword(Player p1) {
        boolean pondering = true;


        if (p1.getSword() && !laserSword) {
            System.out.println("Upgrade to laser sword?");
            System.out.println("1: Yes!");
            System.out.println("2: no.");

            do {
                switch (scanner.nextLine()) {
                    case "1" -> {
                        if (p1.getExp() >= 200) {
                            //p1.setSword(true);
                            spendCurrency(p1,200);
                            System.out.println("You upgraded to laser sword!");

                            weapon.laserSword(p1);
                            laserSword = true;
                            pondering = false;

                        } else {
                            System.out.println("Not enough currency (exp)");
                            pondering = false;
                        }
                    }

                    case "2" -> {
                        System.out.println("But it's really cool!");
                        pondering = false;
                    }

                }

            } while (pondering);

        } else {
            System.out.println("You already have a laser sword");

        }


    }

    void buyShield(Player p1) {
        boolean pondering = true;

        if (!p1.getShield()) {
            System.out.println("Buy a shield?");
            System.out.println("1: Yes!");
            System.out.println("2: no.");

            do {
                switch (scanner.nextLine()) {
                    case "1" -> {
                        if (p1.getExp() >= 10) {
                            //p1.setShield(true);
                            spendCurrency(p1,10);

                            System.out.println("You bought a shield!");
                            weapon.shield(p1);
                            pondering = false;

                        } else {
                            System.out.println("not enough currency (exp)");
                            pondering = false;
                        }
                    }

                    case "2" -> {
                        System.out.println("You decided against buying a shield");
                        pondering = false;
                    }

                }

            } while (pondering);

        } else {
            System.out.println("You already have a shield");

        }


    }


}
