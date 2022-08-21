package com.techelevator.attacks;

import com.techelevator.Creatures.Creature;
import com.techelevator.dice.D20;
import com.techelevator.dice.Dice;

import java.util.List;

public class EldrichBlast implements Attack {

    @Override
    public void use(String attacker, Creature target, int attackPower, List<Dice> attackDice) {
        int targetHealth = target.getCurrentHealth();
        if (targetHealth == 0) {
            return;
        }
        System.out.println(attacker + " uses Eldrich Blast!");
        D20 d20 = new D20();
        int attackRoll = d20.roll();
        int damageRoll = 0;
        for (Dice dice : attackDice) {
            damageRoll += dice.roll();
        }
        if (attackRoll == 20) {
            System.out.println("CRITICAL HIT!!");
            int damage = (2 * damageRoll) + attackPower/3;
            target.setCurrentHealth(targetHealth - damage);
            System.out.println(target.getName() + " takes " + damage + " points of damage!");
        }
        else if (attackRoll > target.getArmor() - 2) {
            System.out.println("HIT!!");
            int damage = damageRoll + attackPower/3;
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
        return "Greater chance to hit, but does less damage.";
    }

    @Override
    public String toString() {
        return "Eldrich Blast";
    }
}
