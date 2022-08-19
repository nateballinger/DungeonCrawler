package com.techelevator.items;

import com.techelevator.Creatures.heros.Hero;

public interface Item {

    public boolean isPotion = false;

    public int use(Hero hero);

    public boolean isPotion();
}
