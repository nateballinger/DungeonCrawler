package com.techelevator.attacks;

import com.techelevator.Creatures.Creature;
import com.techelevator.dice.D20;
import com.techelevator.dice.Dice;

import java.util.List;

public class WhirlwindSlash implements Attack {

    @Override
    public void use(String attacker, Creature target, int attackPower, List<Dice> attackDice) {
        int targetHealth = target.getCurrentHealth();
        if (targetHealth == 0) {
            return;
        }
        System.out.println(attacker + " uses Whirlwind Slash!");
        System.out.println(attacker + " attacks three times!");

        for (int i = 0; i < 3; i++) {
            D20 d20 = new D20();
            int attackRoll = d20.roll();
            int damageRoll = 1;
            for (Dice dice : attackDice) {
                damageRoll += dice.roll() / 3;
            }
            if (attackRoll == 20) {
                System.out.println("CRITICAL HIT!!");
                int damage = (2 * damageRoll) + attackPower/2;
                target.setCurrentHealth(targetHealth - damage);
                System.out.println(target.getName() + " takes " + damage + " points of damage!");
            } else if (attackRoll > target.getArmor()) {
                System.out.println("HIT!!");
                int damage = damageRoll + attackPower/2;
                target.setCurrentHealth(targetHealth - damage);
                System.out.println(target.getName() + " takes " + damage + " points of damage!");


            } else {
                System.out.println("MISS!!");
            }

            targetHealth = target.getCurrentHealth();

            if (target.getCurrentHealth() < 0) {
                target.setCurrentHealth(0);
            }
        }
        target.getStatus();
    }

    @Override
    public String description() {
        return "Make 3 quick slashes that do slightly less damage than normal.\n" +
                "Each slash has a chance to hit, critical hit, or miss.";
    }

    @Override
    public String toString() {
        return "Whirlwind Slash";
    }
}
