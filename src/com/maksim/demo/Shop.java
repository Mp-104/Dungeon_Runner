package com.maksim.demo;

import java.util.Scanner;

public class Shop {

    Scanner scanner = new Scanner(System.in);
    Weapon weapon = new Weapon();

    void menu (Player p1, Monster m1) {
        boolean inShop = true;

        do {
            System.out.println("""
                    Welcome to shop!\s
                    1: Cola - 5 exp
                    2: Burger - 10 exp
                    3: Sword - 20 exp
                    4: Shield - 10 exp""");
            System.out.println("5: Level up - " + (100 + (p1.getLevel() * p1.getLevel() ) -1) + " exp");
            System.out.println("");
            System.out.println("0: Exit Shop");
            System.out.println("Available currency (exp): " + p1.getExp());



            switch (scanner.nextLine()) {
                case "1" -> buyCola(p1);
                case "2" -> buyBurger(p1);
                case "3" -> buySword(p1);
                case "4" -> buyShield(p1);
                case "5" ->buyLevel(p1);
                case "0" -> inShop = false;
                default -> System.out.println("try again");

            }

        } while (inShop);


    }

    void buyLevel (Player p1) {
        boolean pondering = true;

        System.out.println("Level up?");
        System.out.println("1: Yes");
        System.out.println("2: No");

        do {
            switch (scanner.nextLine()) {
                case "1" -> {
                    if (p1.getExp() > 100 + (p1.getLevel() * p1.getLevel()) - 1   ) {
                        p1.setExp(p1.getExp() - (100 + (p1.getLevel() * p1.getLevel()) -1)  );
                        p1.setLevel(p1.getLevel() + 1);
                        System.out.println("You levelled up!");
                        p1.growth(p1);
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
                        p1.setHealth(p1.getHealth() + 50 );  // TODO - Set max HP, or can recover health indefinitely
                        p1.setExp(p1.getExp()- 10 );
                        System.out.println("you ate burger!");
                        System.out.println("recovered 50 health");
                        pondering = false;

                    } else {
                        System.out.println("not enough currency (exp)");
                        pondering = false;
                    }
                }

                case "2" -> {
                    System.out.println("no burger?");
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
                        p1.setExp(p1.getExp()- 5 );
                        System.out.println("you drank cola!");
                        System.out.println("recovered 20 health");
                        pondering = false;

                    } else {
                        System.out.println("not enough currency (exp)");
                        pondering = false;
                    }
                }

                case "2" -> {
                    System.out.println("no cola?");
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
                            p1.setExp(p1.getExp()- 20 );
                            System.out.println("you bought a sword!");

                            weapon.sword(p1);
                            pondering = false;

                        } else {
                            System.out.println("not enough currency (exp)");
                            pondering = false;
                        }
                    }

                    case "2" -> {
                        System.out.println("It's your funeral, hehe");
                        pondering = false;
                    }

                }

            } while (pondering);

        } else {
            System.out.println("You already have a sword");

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
                            p1.setExp(p1.getExp()- 10 );
                            System.out.println("you bought a shield!");
                            weapon.shield(p1);
                            pondering = false;

                        } else {
                            System.out.println("not enough currency (exp)");
                            pondering = false;
                        }
                    }

                    case "2" -> {
                        System.out.println("you decided against buying a shield");
                        pondering = false;
                    }

                }

            } while (pondering);

        } else {
            System.out.println("You already have a shield");

        }


    }


}
