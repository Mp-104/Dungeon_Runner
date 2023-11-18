package com.maksim.test;

import com.maksim.demo.Monster;
import com.maksim.demo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    Monster monster;

    @BeforeEach
    public void createMonster () {
        monster = new Monster();
        monster.setHealth(50);
        monster.setMaxHealth(monster.getHealth());
        monster.setDamage(10);
        monster.setStamina(3);
        monster.setAgility(20);

    }

    @Test
    public void testHealth () {

        assertEquals(monster.getHealth(),monster.getMaxHealth());
    }

    @Test
    public void testDamage () {
        Player player = new Player();
        player.setStrength(10);
        player.setBaseDamage(10);

        assertEquals(50, monster.getHealth());
        assertEquals(monster.getMaxHealth(),monster.getHealth());

        monster.setHealth(monster.getHealth() - player.calculateDamage());

        assertEquals(34 ,monster.getHealth());

        assertNotEquals(monster.getMaxHealth(),monster.getHealth());

    }

}
