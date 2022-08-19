package com.techelevator.Creatures.heros;
import com.techelevator.attacks.ArrowBarrage;
import com.techelevator.attacks.FocusedStrike;
import com.techelevator.dice.D6;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Rogue extends Hero {

    public Rogue(String name) {
        setName(name);
        setMaxHealth(17);
        setCurrentHealth(getMaxHealth());
        setAttackPower(3);
        setArmor(11);
        setHeroClass("Rogue");
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D6());
        setAttackDice(attackDice);
        setHealthDice(new D6());
        setAttack1(new FocusedStrike());
        setAttack2(new ArrowBarrage());

    }

}
