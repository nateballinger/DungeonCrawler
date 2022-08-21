package com.techelevator.Creatures.heros;

import com.techelevator.Creatures.Attacker;
import com.techelevator.Creatures.Creature;
import com.techelevator.attacks.Attack;
import com.techelevator.attacks.StandardAttack;
import com.techelevator.dice.Dice;
import com.techelevator.items.Inventory;
import com.techelevator.Creatures.monsters.Monster;
import com.techelevator.ui.UserInput;

public abstract class Hero extends Creature implements Attacker {

    private int level = 1;
    private int experience = 0;
    private String heroClass;
    private Dice healthDice;
    private Inventory heroBag = new Inventory();
    private Attack standardAttack = new StandardAttack();

    public void heroStatus() {
        System.out.println(getName() + ": Lvl "+ level + " " + heroClass);
        System.out.println("Current Health: " + (getCurrentHealth()) + "/" + getMaxHealth());
        System.out.println("Experience: " + experience);
        System.out.println("Attack Power: " + getAttackPower() + " + " + getAttackDice());
    }

    @Override
    public void getStatus() {
        System.out.println(getName() + " current Health: " + getCurrentHealth());
    }

    public void attack(Monster target) {
        int choice = UserInput.getAttackChoice(standardAttack.toString(), getAttack1().toString(), getAttack2().toString());
        if (choice == 1) {
            standardAttack(target);
        }
        if (choice == 2) {
            attack1(target);
        }
        if (choice == 3) {
            attack2(target);
        }

    }

    public void standardAttack(Creature target) {
        standardAttack.use(getName(), target, getAttackPower(), getAttackDice());
    }

    public void attack1(Creature target){
        getAttack1().use(getName(), target, getAttackPower(), getAttackDice());
    }

    public void attack2(Creature target) {
        getAttack2().use(getName(), target, getAttackPower(), getAttackDice());
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public Dice getHealthDice() {
        return healthDice;
    }

    public void setHealthDice(Dice healthDice) {
        this.healthDice = healthDice;
    }

    public Inventory getHeroBag() {
        return heroBag;
    }
}
