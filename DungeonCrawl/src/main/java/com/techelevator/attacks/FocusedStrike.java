package com.techelevator.attacks;

import com.techelevator.Creatures.Creature;
import com.techelevator.dice.D20;
import com.techelevator.dice.Dice;

import java.util.List;

public class FocusedStrike implements Attack {

    @Override
    public void use(String attacker, Creature target, int attackPower, List<Dice> attackDice) {
        int targetHealth = target.getCurrentHealth();
        if (targetHealth == 0) {
            return;
        }
        System.out.println(attacker + " uses Focused Strike!");
        D20 d20 = new D20();
        int attackRoll = d20.roll();
        int damageRoll = 0;
        for (Dice dice : attackDice) {
            damageRoll += dice.roll();
        }
        if (attackRoll > 18) {
            System.out.println("CRITICAL HIT!!");
            int damage = (3 * damageRoll) + attackPower;
            target.setCurrentHealth(targetHealth - damage);
            System.out.println(target.getName() + " takes " + damage + " points of damage!");
        }
        else if (attackRoll > target.getArmor() + 1) {
            System.out.println("HIT!!");
            int damage = damageRoll + attackPower/2;
            target.setCurrentHealth(targetHealth - damage);
            System.out.println(target.getName() + " takes " + damage + " points of damage!");


        } else {
            System.out.println("MISS!!");
        }

        if (target.getCurrentHealth() < 0) {
            target.setCurrentHealth(0);
        }
        target.getStatus();
    }

    @Override
    public String description() {
        return "Increased chance for critical hits and critical hit damage. \n " +
                "Less damage on non-critical hits and greater chance of missing.";
    }

    @Override
    public String toString() {
        return "Focused Strike";
    }
}
