package com.techelevator.Creatures.heros;

public class LevelUp {

    public static void addExperience(Hero hero, int experienceGained) {
        int previousExp = hero.getExperience();
        int newExp = previousExp + experienceGained;
        hero.setExperience(newExp);
        boolean leveledUp = false;
        if ( (newExp / (20 * hero.getLevel())) + 1 > hero.getLevel()) {
            System.out.println("LEVEL UP!!");
            hero.setMaxHealth((int)(hero.getMaxHealth() * 1.1 + hero.getHealthDice().roll()));
            hero.setCurrentHealth(hero.getMaxHealth());
            hero.setLevel(hero.getLevel() + 1);
            leveledUp = true;
        }
        if (leveledUp && hero.getLevel() % 2 == 1) {
            hero.setAttackPower(hero.getAttackPower() + 1);
        }
        if (leveledUp) {
            hero.heroStatus();
        }
    }
}
