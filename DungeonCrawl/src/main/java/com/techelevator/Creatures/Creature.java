package com.techelevator.Creatures;

import com.techelevator.attacks.Attack;
import com.techelevator.dice.Dice;

import java.util.List;

public abstract class Creature {

    private int maxHealth;
    private int currentHealth;
    private int armor;
    private int attackPower;
    private String name;
    private List<Dice> attackDice;
    private Attack attack1;
    private Attack attack2;

    public void getStatus() {

    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dice> getAttackDice() {
        return attackDice;
    }

    public void setAttackDice(List<Dice> attackDice) {
        this.attackDice = attackDice;
    }

    public Attack getAttack1() {
        return attack1;
    }

    public void setAttack1(Attack attack1) {
        this.attack1 = attack1;
    }

    public Attack getAttack2() {
        return attack2;
    }

    public void setAttack2(Attack attack2) {
        this.attack2 = attack2;
    }
}
