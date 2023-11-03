package com.maksim.test;

import com.maksim.demo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;

    @BeforeEach
    public void beforeEachTest () {
         player = new Player(5,
                5,
                5,
                50,
                2,
                5);


        System.out.println("ready to work");

    }


    @Test
    public void reducePlayerHealth () {
        player.takeDamage(5);

        assertEquals(45,player.getHealth());
    }

    @Test
    public void reducePlayerLevel () {
        player.setLevel(player.getLevel() - 1);

        assertEquals(1, player.getLevel());
    }

    @Test
    public void checkStartingHealth () {
        System.out.println(player.getHealth());

        assertEquals(50, player.getHealth());
    }




}



