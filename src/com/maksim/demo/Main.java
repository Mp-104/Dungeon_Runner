package com.maksim.demo;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        DBConnection db = new DBConnection();
        db.open();


        if (db.getPlayerIDCount() < 1) {
            System.out.println("1. New player");
            do {
                switch (sc.nextInt()) {
                    case 1 -> game.menu();

                    default -> System.out.println("Try again");
                }

            } while (true);

        } else {
            do {
                System.out.println("1. New player");
                System.out.println("2. Load player");
                switch (sc.nextLine()) {
                    case "1" -> game.menu();
                    case "2"-> game.loadMenu();
                    default -> System.out.println("Try again");
                }

            } while (true);

        }





        // loadgame.menu2(); + switch sats för att välja new game eller ladda spelare från databas

    }


    }

