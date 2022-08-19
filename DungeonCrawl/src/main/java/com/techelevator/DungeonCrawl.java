package com.techelevator;

import com.techelevator.dice.D20;
import com.techelevator.dice.D6;
import com.techelevator.Creatures.heros.Barbarian;
import com.techelevator.Creatures.heros.Hero;
import com.techelevator.Creatures.heros.Rogue;
import com.techelevator.Creatures.heros.Wizard;
import com.techelevator.items.Potion;
import com.techelevator.items.SmokeBomb;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.Scanner;

public class DungeonCrawl {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserOutput.printGameTitle();

        int heroChoiceNumber = UserInput.getHeroChoice();
        String name = UserInput.getHeroName();

        System.out.println();

        Hero hero;

        Potion potion = new Potion();
        SmokeBomb smokeBomb = new SmokeBomb();

        if (heroChoiceNumber == 1) {
            hero = new Barbarian(name);
        }
        else if (heroChoiceNumber == 2) {
            hero = new Rogue(name);
        }
        else {
            hero = new Wizard(name);
        }

        hero.getHeroBag().addItem(potion, 2);
        hero.getHeroBag().addItem(smokeBomb, 0);
        hero.heroStatus();

        UserOutput.printAdventureBegins();
        UserInput.hitReturn();


        boolean isGameOver = false;
        boolean isAmbush = false;

        while (!isGameOver) {

            Battle battle = new Battle(hero.getLevel());
            isGameOver = battle.battle(hero, potion, smokeBomb, isAmbush);
            isAmbush = false;

            if(!isGameOver) {
                //make a choice to continue, rest, or use an item
                while (true) {
                    String continueChoice = UserInput.getContinueChoice();
                    if (continueChoice.equals("kick")) {
                        System.out.println("You kick down the next door!");
                        break;
                    }
                    if (continueChoice.equals("item")) {
                        hero.getHeroBag().showInventory(false);
                        String choice = UserInput.pickItem(hero.getHeroBag(),potion,smokeBomb);

                        if (choice.equals("potion")) {
                            hero.getHeroBag().useItem(potion, hero);
                            scanner.nextLine();
                        }
                        //use item stuff
                    }
                    if (continueChoice.equals("rest")){
                        D20 d20 = new D20();
                        int restRoll = d20.roll();
                        if (restRoll - hero.getLevel()/2 > 7) {
                            D6 d6 = new D6();
                            int healRoll = d6.roll() + hero.getLevel() * 2;
                            if (hero.getCurrentHealth() + healRoll > hero.getMaxHealth()) {
                                System.out.println("You are fully healed!");
                                hero.setCurrentHealth(hero.getMaxHealth());

                            } else {
                                System.out.println("You recovered " + healRoll + " points of health.");
                                hero.setCurrentHealth(hero.getCurrentHealth() + healRoll);
                            }
                            scanner.nextLine();
                            System.out.println("You enter the next room of the dungeon.");
                        } else {
                            System.out.println("AMBUSH!!");
                            isAmbush = true;
                        }
                        scanner.nextLine();
                        break;
                    }
                }

            }


        }

        /*
        scanner.nextLine();
        System.out.println("Prepare for battle!!");
        scanner.nextLine();

        System.out.println("A rat appears!");
        Rat rat = new Rat(hero.getLevel());
        while (rat.getHealth() > 0) {
            System.out.println("Hit \"Enter\" to attack");
            scanner.nextLine();
            hero.attack(rat);
            scanner.nextLine();
            if (rat.getHealth() == 0) {
                break;
            }
            System.out.println("The rat attacks!");
            scanner.nextLine();
            rat.attack(hero);
            scanner.nextLine();
        }
        System.out.println();
        System.out.println("The rat has been defeated!");

         */


    }
}
