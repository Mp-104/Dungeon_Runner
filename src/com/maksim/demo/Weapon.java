package com.maksim.demo;

public class Weapon {

    void sword (Player p1) {
        p1.setSword(true);

            System.out.println(p1.getName() + " has sword");
            System.out.println("Strength + 20");
            p1.setStrength(p1.getStrength() + 20);


    }

    void laserSword (Player p1) {

        System.out.println(p1.getName() + " has laser sword");
        System.out.println("Strength + 100");
        p1.setStrength(p1.getStrength() + 100);
    }

    void shield (Player p1) {
        p1.setShield(true);

        System.out.println(p1.getName() + " has shield");
        //p1.setDefence(p1.getDefence() + 10);
        //m1.setDamage(m1.getDamage()/2);

    }


}
