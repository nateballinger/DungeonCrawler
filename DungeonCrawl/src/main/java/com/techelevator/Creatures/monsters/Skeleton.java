package com.techelevator.Creatures.monsters;

import com.techelevator.Creatures.Attacker;
import com.techelevator.Creatures.Creature;
import com.techelevator.attacks.BoneBoomerang;
import com.techelevator.attacks.BoneClub;
import com.techelevator.dice.D2;
import com.techelevator.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class Skeleton extends Monster implements Attacker {

    public Skeleton(int level) {
        setArmor(4 + (level/2) * 1);
        setAttackPower(0 + (level/2) * 1);
        setCurrentHealth(10 + level * 2);
        setMaxHealth(getCurrentHealth());
        setName("Skeleton");
        List<Dice> attackDice = new ArrayList<>();
        attackDice.add(new D2());
        setAttackDice(attackDice);
        setExperience(10 + (level - 1) * 5);
        setAttack1(new BoneClub());
        setAttack2(new BoneBoomerang());
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
