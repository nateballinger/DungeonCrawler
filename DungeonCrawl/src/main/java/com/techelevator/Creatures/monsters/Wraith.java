package com.techelevator.Creatures.monsters;

import com.techelevator.Creatures.Attacker;
import com.techelevator.attacks.Fireball;
import com.techelevator.attacks.WhirlwindSlash;
import com.techelevator.dice.D4;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Wraith extends Monster implements Attacker {

    public Wraith(int level) {
        setArmor(5 + (level/2) * 1);
        setAttackPower(5 + (int)((level/2) * 1.5));
        setCurrentHealth(5 + level * 2);
        setMaxHealth(getCurrentHealth());
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D4());
        setAttackDice(attackDice);
        setName("Wraith");
        setExperience(20 + (level - 1) * 5);
        setAttack1(new Fireball());
        setAttack2(new WhirlwindSlash());
    }

}
