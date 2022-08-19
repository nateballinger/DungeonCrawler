package com.techelevator;

import com.techelevator.dice.D20;
import com.techelevator.dice.D6;
import com.techelevator.Creatures.heros.Hero;
import com.techelevator.Creatures.heros.LevelUp;
import com.techelevator.items.Potion;
import com.techelevator.items.SmokeBomb;
import com.techelevator.Creatures.monsters.Imp;
import com.techelevator.Creatures.monsters.Monster;
import com.techelevator.Creatures.monsters.Rat;
import com.techelevator.Creatures.monsters.Skeleton;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.*;

public class Battle {

    private int heroLevel;
    private Scanner scanner = new Scanner(System.in);


    public Battle(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public boolean battle(Hero hero, Potion potion, SmokeBomb smokeBomb, boolean isAmbush) {
        int numberOfMonsters = getNumberOfMonsters();
        System.out.println();

        Map<String, Monster> currentBattleMonsters = monsterMapMaker(numberOfMonsters);
        String[] currentMonsterArray = monsterArrayMaker(currentBattleMonsters);

        UserOutput.printMonsters(currentBattleMonsters);
        scanner.nextLine();

        int experienceGained = 0;
        boolean isBattleOver = false;
        boolean isEscaped = false;
        while (!isBattleOver) {
            if (numberOfMonsters != 0) {
                while (!isAmbush) {
                    //UserOutput.printBattleChoices();
                    String battleChoice = UserInput.getBattleChoice();
                    if (battleChoice.equals("attack")) {
                        //Prompt user to pick target, take input choice, use hero.attack on selected target.
                        //UserOutput.printTargetChoices(currentMonsterArray);
                        String target = UserInput.getTarget(currentMonsterArray);
                        hero.attack(currentBattleMonsters.get(target));
                        scanner.nextLine();
                        break;
                    }
                    if (battleChoice.equals("item")) {
                        //select item from inventory use item
                        hero.getHeroBag().showInventory(true);

                        String choice = UserInput.pickItem(hero.getHeroBag(), potion, smokeBomb);

                        if (choice.equals("potion")) {
                            hero.getHeroBag().useItem(potion, hero);
                            scanner.nextLine();
                            break;
                        }
                        if (choice.equals("smoke")) {
                            hero.getHeroBag().useItem(smokeBomb, hero);
                            isBattleOver = true;
                            isEscaped = true;
                            scanner.nextLine();
                            break;
                        }
                        if (choice.equals("back")) {
                            continue;                       //TODO: continue working on use item.
                        }

                    }
                    if (battleChoice.equals("run")) {
                        //attempt to flee battle.
                        isBattleOver = run(currentBattleMonsters.size());
                        if (isBattleOver) {
                            isEscaped = true;
                        }
                        scanner.nextLine();
                        break;
                    }
                }
            }
            isAmbush = false;


            //check if any monsters are alive, and if so continues the battle.  Otherwise sets isBattleOver to true.
            int totalEnemyRemainingHealth = 0;
            String defeatedMonster = "";
            for (Map.Entry<String,Monster> entry : currentBattleMonsters.entrySet()) {
                totalEnemyRemainingHealth += entry.getValue().getCurrentHealth();
                if (entry.getValue().getCurrentHealth() <= 0) {
                    defeatedMonster = entry.getKey();
                    experienceGained += entry.getValue().getExperience();
                }
            }
            if (currentBattleMonsters.containsKey(defeatedMonster)) {
                currentBattleMonsters.remove(defeatedMonster);
                currentMonsterArray = monsterArrayMaker(currentBattleMonsters);
            }
            if (totalEnemyRemainingHealth == 0) {
                isBattleOver = true;
                System.out.println("You have defeated all of the monsters in this room!");
                System.out.println("You gained " + experienceGained + " experience!");
                LevelUp.addExperience(hero,experienceGained);
                scanner.nextLine();

                int[] loot = getLoot();
                if (loot[0] == 1) {
                    hero.getHeroBag().addItem(potion,loot[1]);      //TODO will need to update code when there are more items.
                    System.out.println("You found " + loot[1] + " potion(s).");
                } else if (loot[0] == 2) {
                    hero.getHeroBag().addItem(smokeBomb,loot[1]);
                    System.out.println("You found " + loot[1] + " smoke bomb(s).");
                } else {
                    System.out.println("You didn't find any loot...");
                }
                scanner.nextLine();


            }

            //Monsters all attack hero
            if (!isEscaped) {
                for (Map.Entry<String, Monster> entry : currentBattleMonsters.entrySet()) {
                    if (entry.getValue().getCurrentHealth() > 0 && hero.getCurrentHealth() > 0) {
                        System.out.println(entry.getKey() + " attacks!");
                        entry.getValue().attack(hero);
                        scanner.nextLine();
                    }
                }
            }

            //Checks if hero has health left.  If not, ends battle.
            if (hero.getCurrentHealth() == 0) {
                isBattleOver = true;
                System.out.println("You have died.");

            }
        }
        return (hero.getCurrentHealth() == 0);



    }

    private int getNumberOfMonsters() {
        D20 d20 = new D20();
        int numberOfMonsters = 0;
        int numberOfMonstersRoll = d20.roll();
        if (numberOfMonstersRoll > 1) {
            numberOfMonsters++;
        }
        if (numberOfMonstersRoll > 11) {
            numberOfMonsters++;
        }
        if (numberOfMonstersRoll > 17) {
            numberOfMonsters++;
        }
        if (numberOfMonsters == 1) {
            System.out.println("A monster appears!");
        } else {
            System.out.println(numberOfMonsters + " monsters appear!");
        }
        return numberOfMonsters;
    }

    private Map<String, Monster> monsterMapMaker(int numberOfMonsters) {
        Map<String, Monster> currentBattleMonsters = new TreeMap<>();
        for (int i = 0; i < numberOfMonsters; i++) {
            Monster monsterToAdd = getRandomMonster(heroLevel);

            String monsterName = monsterToAdd.getName() + " A";
            if (currentBattleMonsters.containsKey(monsterName)) {
                monsterName = monsterName.substring(0,monsterName.length() - 1) + "B";
            }
            if (currentBattleMonsters.containsKey(monsterName)) {
                monsterName = monsterName.substring(0,monsterName.length() - 1) + "C";
            }
            currentBattleMonsters.put(monsterName, monsterToAdd);
        }
        return currentBattleMonsters;
    }

    private String[] monsterArrayMaker(Map<String,Monster> monsterMap) {
        String[] array = new String[monsterMap.size()];
        int index = 0;
        for (Map.Entry<String,Monster> entry : monsterMap.entrySet()) {
            array[index] = entry.getKey();
            index++;
        }
        return array;
    }

    private Monster getRandomMonster(int level) {
        List<Monster> monsterList = new ArrayList<>();
        monsterList.add(new Rat(level));        //TODO: Consider making .csv files or database that hold monsters that are available at various levels.
        monsterList.add(new Skeleton(level));
        monsterList.add(new Imp(level));

        D20 d20 = new D20();
        int monsterRoll = d20.roll() % (monsterList.size());
        return monsterList.get(monsterRoll);
    }

    private boolean run(int monstersRemaining) {
        D20 d20 = new D20();
        int runRoll = d20.roll();
        if (runRoll > 10 + 2 * monstersRemaining) {
            System.out.println("You escape the battle!");
            return true;
        }
        System.out.println("You were not able to escape!");
        return false;
    }

    private int[] getLoot() {
        D20 d20 = new D20();
        D6 d6 = new D6();
        int loot = 0;
        int numOfLootRoll = d20.roll();
        int lootRoll = d6.roll();
        if (lootRoll > 4) {
            loot = 2;
        } else {
            loot = 1;
        }
        if (numOfLootRoll == 20) {
            return new int[]{loot, 3};
        }
        if (numOfLootRoll > 15) {
            return new int[] {loot, 2};
        }
        if (numOfLootRoll > 10) {
            return new int[] {loot, 1};
        }
        return  new int[] {0,0};
    }



}
