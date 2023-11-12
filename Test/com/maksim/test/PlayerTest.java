package com.maksim.test;

import com.maksim.demo.Game;
import com.maksim.demo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;
    Game game = new Game();


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

    @Test
    public void checkDamage() {

        assertEquals(player.getBaseDamage() + player.getStrength()  , player.calculateDamage() );

    }

    @Test
    public void checkLvlUp () {

        assertEquals(2, player.getLevel());

        player.growth();

        assertEquals(2+1,player.getLevel());
    }

    @Test
    public void checkLvlUpIntelligence () {

        assertEquals(5, player.getIntelligence());

        player.growth();

        assertEquals(5+2, player.getIntelligence() );
    }

    @Test
    public void checkLvlUpStrength () {

        assertEquals(5, player.getStrength());

        player.growth();

        assertEquals(5+2, player.getStrength());

    }
    @Test
    public void checkLvlUpAgility () {

        assertEquals(5, player.getAgility());

        player.growth();

        assertEquals(5+2, player.getAgility());

    }

    @Test
    public void checkGameOver () {

        player.setHealth(0);

       if (player.getHealth() <= 0) {
           player.setAlive(false);

       } else {
           player.setAlive(true);
       }

       assertFalse(player.getAlive());

    }

    @Test
    public void playerExist () {
        assertNotNull(player);
    }

    @Test
    public void critDamage() {

        player.setIntelligence(0);
        player.crit();
        assertEquals(5, player.getBaseDamage());

        player.setIntelligence(100);
        player.crit();

        assertEquals(10, player.getBaseDamage());


    }



}



