package com.techelevator.ui;

import com.techelevator.items.Inventory;
import com.techelevator.items.Potion;
import com.techelevator.items.SmokeBomb;

import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static int getHeroChoice() {
        System.out.println("Welcome to the Dungeon!  Please select your hero!");
        System.out.println("1.) Barbarian      2.) Rogue      3.) Wizard");
        System.out.println();
        System.out.print("Enter the number for the character you wish play: ");
        int heroChoiceNumber;
        while (true){
            String heroChoice = scanner.nextLine();
            if (heroChoice.equals("1") || heroChoice.equals("2") || heroChoice.equals("3")) {
                heroChoiceNumber = Integer.parseInt(heroChoice);
                break;
            }
            System.out.println("Invalid entry.  Please enter \"1\" to play as the barbarian, \"2\" to play as the rogue, or \"3\" to play as the wizard.");
        }
        return heroChoiceNumber;
    }

    public static String getHeroName(){
        System.out.println("Enter a name for your hero.");
        return scanner.nextLine();
    }

    public static String getContinueChoice() {
        System.out.println("What would you like to do next?");
        System.out.println("[K]ick down the next door.");
        System.out.println("Use an [I]tem.");
        System.out.println("Take a short [R]est.");
        System.out.println("Get [A]ttack information.");
        System.out.println("**WARNING: You may be ambushed during short rests.");

        String choice = "";
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("k")) {
            choice = "kick";
        } else if (input.equalsIgnoreCase("i")) {
            choice = "item";
        } else if (input.equalsIgnoreCase("r")) {
            choice = "rest";
        } else if (input.equalsIgnoreCase("a")) {
            choice = "attack";
        } else {
            System.out.println("**Invalid choice**");
            System.out.println();
            choice = getContinueChoice();
        }

        return choice;
    }

    public static String getBattleChoice() {
        System.out.println("What would you like to do?");
        System.out.println("[A]ttack");
        System.out.println("Use [I]tem");
        System.out.println("[R]un");
        String choice = "";
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("a")) {
            choice = "attack";
        }
        else if (input.equalsIgnoreCase("i")) {
            choice = "item";
        }
        else if (input.equalsIgnoreCase("r")) {
            choice = "run";
        } else {
            System.out.println("**Invalid choice**");
            System.out.println();
            choice = getBattleChoice();
        }
        return choice;
    }

    public static int getAttackChoice(String standard, String attack1, String attack2) {
        int choice;
        while(true) {
            System.out.println("Pick an attack:");
            System.out.println("[1] " + standard);
            System.out.println("[2] " + attack1);
            System.out.println("[3] " + attack2);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("**Invalid choice**");
                choice = getAttackChoice(standard, attack1, attack2);
            }
            if (choice != 1 && choice != 2 && choice != 3) {
                choice = getAttackChoice(standard, attack1, attack2);
            }
        }
        return choice;
    }

    public static String getTarget(String[] monsterArray) {
        System.out.println("Choose your target:");
        for (int i = 1; i <= monsterArray.length; i++) {
            System.out.println("[" + i + "] " + monsterArray[i - 1]);
        }
        int choiceNumber;
        while (true) {
            try {
                String input = scanner.nextLine();
                choiceNumber = Integer.parseInt(input);
                if (choiceNumber > monsterArray.length || choiceNumber < 1) {
                    System.out.println("Not a valid entry.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid entry.");
            }
        }
        return monsterArray[choiceNumber - 1];

    }

    public static String pickItem(Inventory inventory, Potion potion, SmokeBomb smokeBomb) {    //TODO: force only valid key entries
        System.out.println("Select an item to use. (Hit 'x' to go back):");
        boolean hasPotion = inventory.getInventory().get(potion) > 0;
        boolean hasSmokebomb = inventory.getInventory().get(smokeBomb) > 0;
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("p") && hasPotion) {
            return "potion";
        } else if (choice.equalsIgnoreCase("s") && hasSmokebomb) {
            return "smoke";
        } else if (choice.equalsIgnoreCase("x")) {
            return "back";
        } else {
            return pickItem(inventory, potion, smokeBomb);
        }
    }

    public static void hitReturn() {
        scanner.nextLine();
    }
}
