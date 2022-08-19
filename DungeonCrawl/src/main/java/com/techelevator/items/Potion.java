package com.techelevator.items;

import com.techelevator.dice.D8;
import com.techelevator.Creatures.heros.Hero;

public class Potion implements Item{

    private boolean isPotion = true;
    private String name = "potion";

    @Override
    public int use(Hero hero) {
        D8 d8 = new D8();
        int healRoll = d8.roll() + 7;
        int currentHealth = hero.getCurrentHealth();
        int amountHealed;
        if (currentHealth + healRoll > hero.getMaxHealth()) {
            amountHealed = hero.getMaxHealth() - currentHealth;
            hero.setCurrentHealth(hero.getMaxHealth());
        } else {
            hero.setCurrentHealth(currentHealth + healRoll);
            amountHealed = healRoll;
        }
        System.out.println("Used a potion! Healed " + amountHealed + " points!");
        System.out.println("Current health: " + hero.getCurrentHealth());
        return amountHealed;
    }

    @Override
    public String toString() {
        return "[P]otion (heal 7 + [D8] points)";
    }

    public boolean isPotion() {
        return isPotion;
    }

    public String getName() {
        return name;
    }
}
