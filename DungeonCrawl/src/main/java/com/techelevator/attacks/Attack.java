package com.techelevator.attacks;

import com.techelevator.Creatures.Creature;
import com.techelevator.dice.D20;
import com.techelevator.dice.Dice;

import java.util.List;

public interface Attack {

    void use(String attacker, Creature target, int attackPower, List<Dice> attackDice);

}
