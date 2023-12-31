package com.maksim.test;

import com.maksim.demo.Monster;
import com.maksim.demo.Player;
import com.maksim.demo.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

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
        Monster m1 = new Monster();
        m1.setDamage(10);

        player.setHealth(player.getHealth() - m1.getDamage() );

        assertEquals(40,player.getHealth());
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

        assertEquals(player.getBaseDamage() + ( player.getStrength()*2/4+1 )  , player.calculateDamage() );

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

    @RepeatedTest(10)
    public void critDamage() {
        // Should always crit
        player.setIntelligence(100);
        player.crit();

        assertEquals(20, player.getBaseDamage());

    }

    @RepeatedTest(10)
    public void noCritDamage () {
        // Should never crit
        player.setIntelligence(0);
        player.crit();

        assertEquals(5, player.getBaseDamage());

    }


    @RepeatedTest(2000)
    public void FiftyPercentCritDamage () { // about 50% of tests should pass

        player.setIntelligence(50);
        player.crit();

        assertEquals(20, player.getBaseDamage());
    }

    @RepeatedTest(1000)
    public void TenPercentCritDamage () { // about 10% of tests should pass.

        player.setIntelligence(10);
        player.crit();

        assertEquals(20, player.getBaseDamage());

    }


    @Test
    public void writerExists () throws IOException {

        Writer writer = new BufferedWriter(
                        new OutputStreamWriter(
                        new FileOutputStream("test.txt"), StandardCharsets.UTF_8));


        assertNotNull( writer );

    }

    @Test
    public void resultExists () {
        Result result = new Result();

        assertNotNull(result);

    }


}



