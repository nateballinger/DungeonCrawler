package com.techelevator.items;

import com.techelevator.Creatures.heros.Hero;

public class SmokeBomb implements Item{

    private boolean isPotion = false;
    private String name = "smoke bomb";

    @Override
    public int use(Hero hero) {
        System.out.println("You escape in a cloud of smoke!");
        return 1;
    }

    @Override
    public String toString() {
        return "[S]moke bomb (automatically escape from current battle)";
    }

    public boolean isPotion() {
        return isPotion;
    }

    public String getName() {
        return name;
    }
}
