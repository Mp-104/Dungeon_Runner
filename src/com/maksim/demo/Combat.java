package com.maksim.demo;

public interface Combat {


    int speed ();

    void health ();

    void damage ();

    void fight(Player p1, Monster m1);

    void fightSecond (Monster m1, Player p1);

    void defend (Monster m1, Player p1);

    void flee (Player p1, Monster m1);

}
