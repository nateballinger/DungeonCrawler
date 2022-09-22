package com.techelevator.Creatures.monsters;

import com.techelevator.Creatures.Attacker;
import com.techelevator.attacks.Bite;
import com.techelevator.attacks.Scratch;
import com.techelevator.dice.D4;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Zombie extends Monster implements Attacker {

    public Zombie(int level) {
        setArmor(8 + (level/2) * 1);
        setAttackPower(3 + (level/2) * 1);
        setCurrentHealth(3 + (int)(level * 1.5));
        setMaxHealth(getCurrentHealth());
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D4());
        setAttackDice(attackDice);
        setName("Zombie");
        setExperience(15 + (level - 1) * 5);
        setAttack1(new Bite());
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
