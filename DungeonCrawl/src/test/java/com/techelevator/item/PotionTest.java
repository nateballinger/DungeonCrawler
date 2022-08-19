package com.techelevator.item;

import com.techelevator.Creatures.heros.Barbarian;
import com.techelevator.items.Potion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PotionTest {

    private Barbarian testBarbarian;
    private Potion potion;

    @Before
    public void setup() {
        testBarbarian = new Barbarian("test");
        potion = new Potion();
    }

    @Test
    public void potions_do_not_heal_more_than_max_health() {
        testBarbarian.setCurrentHealth(19);
        potion.use(testBarbarian);
        int actualHealth = testBarbarian.getCurrentHealth();
        Assert.assertEquals(20, actualHealth);
    }

    @Test
    public void potions_heal_amount_declared() {
        for (int i = 0; i < 100; i++) {
            testBarbarian.setCurrentHealth(2);
            int healedAmount = potion.use(testBarbarian);
            int actualHealth = testBarbarian.getCurrentHealth();
            Assert.assertEquals(2 + healedAmount, actualHealth);
        }
    }
}
