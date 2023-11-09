package com.maksim.demo;

public class Weapon {
// Inherit from Shop interface buy()

    public void sword (Player p1) {
        p1.setSword(true);

            System.out.println(p1.getName() + " has sword");
            p1.setStrength(p1.getStrength() + 20);


    }

    void shield (Monster m1, Player p1) {
        p1.setShield(true);

        System.out.println(p1.getName() + " has shield");
        //p1.setDefence(p1.getDefence() + 10);
        //m1.setDamage(m1.getDamage()/2);

    }


}
