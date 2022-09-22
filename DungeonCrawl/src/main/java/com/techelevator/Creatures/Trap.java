package com.techelevator.Creatures;

import com.techelevator.attacks.Attack;
import com.techelevator.attacks.BearTrap;
import com.techelevator.attacks.PoisonDartTrap;
import com.techelevator.dice.D20;

public class Trap implements Attacker{

    private Attack attack1 = new BearTrap();
    private Attack attack2 = new PoisonDartTrap();

    public void attack(Creature target) {
        D20 d20 = new D20();
        int attackRoll = d20.roll();
        if (attackRoll > 10) {
            if (attackRoll > 15) {
                attack1(target);
            } else {
                attack2(target);
            }
        } else {
            noTrap();
        }
    }

    @Override
    public void attack1(Creature target) {
        this.attack1.use(attack1.toString(),target,target.getAttackPower(),target.getAttackDice());
    }

    @Override
    public void attack2(Creature target) {
        this.attack2.use(attack2.toString(),target, target.getAttackPower(), target.getAttackDice());
    }

    public void noTrap() {
        System.out.println("There does not appear to be any traps in the room!");
    }
}
