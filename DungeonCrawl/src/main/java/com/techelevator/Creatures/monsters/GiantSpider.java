package com.techelevator.Creatures.monsters;

import com.techelevator.Creatures.Attacker;
import com.techelevator.attacks.Bite;
import com.techelevator.attacks.Lunge;
import com.techelevator.dice.D2;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class GiantSpider extends Monster implements Attacker {

    public GiantSpider(int level) {
        setArmor(5 + (level/2) * 1);
        setAttackPower(3 + (level/2) * 1);
        setCurrentHealth(8 + (int)(level * 2.5));
        setMaxHealth(getCurrentHealth());
        setName("Giant Spider");
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D2());
        setAttackDice(attackDice);
        setExperience(10 + (level - 1) * 5);
        setAttack1(new Bite());
        setAttack2(new Lunge());
    }

}
