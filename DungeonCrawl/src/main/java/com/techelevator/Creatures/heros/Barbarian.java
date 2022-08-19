package com.techelevator.Creatures.heros;

import com.techelevator.attacks.BarbarianBash;
import com.techelevator.attacks.WhirlwindSlash;
import com.techelevator.dice.D6;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Barbarian extends Hero {

    public Barbarian (String name) {
        setName(name);
        setMaxHealth(20);
        setCurrentHealth(getMaxHealth());
        setAttackPower(2);
        setArmor(12);
        setHeroClass("Barbarian");
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D6());
        setAttackDice(attackDice);
        setHealthDice(new D6());
        setAttack1(new BarbarianBash());
        setAttack2(new WhirlwindSlash());
    }
}
