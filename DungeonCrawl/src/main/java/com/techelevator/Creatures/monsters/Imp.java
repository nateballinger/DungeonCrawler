package com.techelevator.Creatures.monsters;

import com.techelevator.Creatures.Attacker;
import com.techelevator.Creatures.Creature;
import com.techelevator.attacks.Fireball;
import com.techelevator.attacks.Scratch;
import com.techelevator.dice.D4;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Imp extends Monster implements Attacker {

    public Imp(int level) {
        setArmor(6 + (level/2) * 1);
        setAttackPower(0 + (level/2) * 1);
        setCurrentHealth(5 + level * 2);
        setMaxHealth(getCurrentHealth());
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D4());
        setAttackDice(attackDice);
        setName("Imp");
        setExperience(10 + (level - 1) * 5);
        setAttack1(new Fireball());
        setAttack2(new Scratch());
    }

//    @Override
//    public void attack1(Creature target) {
//        getAttack1().use(getName(), target, getAttackPower(), getAttackDice());
//        System.out.println(target.getName() + " current Health: " + target.getCurrentHealth());
//    }
//
//    @Override
//    public void attack2(Creature target) {
//        getAttack2().use(getName(), target, getAttackPower(), getAttackDice());
//        System.out.println(target.getName() + " current Health: " + target.getCurrentHealth());
//    }
}
