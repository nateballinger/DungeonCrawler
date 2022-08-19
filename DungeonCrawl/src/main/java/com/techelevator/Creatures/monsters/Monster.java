package com.techelevator.Creatures.monsters;

import com.techelevator.Creatures.Attacker;
import com.techelevator.Creatures.Creature;
import com.techelevator.dice.D2;
import com.techelevator.Creatures.heros.Hero;

public abstract class Monster extends Creature implements Attacker {

    private int experience;

    public void attack(Hero target) {
        D2 d2 = new D2();
        int attackChoice = d2.roll();
        if (attackChoice == 1) {
            attack1(target);
        } else {
            attack2(target);
        }
    }

    @Override
    public void getStatus() {
        if (getCurrentHealth() / (double) getMaxHealth() >= .50 ) {
            System.out.println("The " + getName() + " is looking pretty healthy.");
        }
         else if (getCurrentHealth() / (double) getMaxHealth() >= .20 ) {
            System.out.println("The " + getName() + " is looking a bit beat up.");
        } else if (getCurrentHealth() / (double) getMaxHealth() > 0.0) {
            System.out.println("The " + getName() + " is looking really rough.");
        } else {
            System.out.println("The " + getName() + " has been defeated!");
        }
    }

    @Override
    public void attack1(Creature target) {
        getAttack1().use(getName(), target, getAttackPower(), getAttackDice());
    }

    @Override
    public void attack2(Creature target) {
        getAttack2().use(getName(), target, getAttackPower(), getAttackDice());
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


}
