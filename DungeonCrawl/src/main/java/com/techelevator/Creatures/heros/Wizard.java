package com.techelevator.Creatures.heros;

import com.techelevator.attacks.EldrichBlast;
import com.techelevator.attacks.Firebolt;
import com.techelevator.dice.D4;
import com.techelevator.dice.D8;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Hero {

    public Wizard(String name) {
        setName(name);
        setMaxHealth(14);
        setCurrentHealth(getMaxHealth());
        setAttackPower(2);
        setArmor(10);
        setHeroClass("Wizard");
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D8());
        setAttackDice(attackDice);
        setHealthDice(new D4());
        setAttack1(new Firebolt());
        setAttack2(new EldrichBlast());
    }
}
