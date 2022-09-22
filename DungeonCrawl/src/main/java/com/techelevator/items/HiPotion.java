package com.techelevator.items;

import com.techelevator.Creatures.heros.Hero;
import com.techelevator.dice.D12;


public class HiPotion implements Item{

    private boolean isPotion = true;
    private String name = "hi-potion";

    @Override
    public int use(Hero hero) {
        D12 d12 = new D12();
        int healRoll = d12.roll() + 13;
        int currentHealth = hero.getCurrentHealth();
        int amountHealed;
        if (currentHealth + healRoll > hero.getMaxHealth()) {
            amountHealed = hero.getMaxHealth() - currentHealth;
            hero.setCurrentHealth(hero.getMaxHealth());
        } else {
            hero.setCurrentHealth(currentHealth + healRoll);
            amountHealed = healRoll;
        }
        System.out.println("Used a hi-potion! Healed " + amountHealed + " points!");
        System.out.println("Current health: " + hero.getCurrentHealth());
        return amountHealed;
    }

    @Override
    public String toString() {
        return "[H]i-Potion (heal 13 + [D12] points)";
    }

    public boolean isPotion() {
        return isPotion;
    }

    public String getName() {
        return name;
    }
}
