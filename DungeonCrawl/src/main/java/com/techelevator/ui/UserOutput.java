package com.techelevator.ui;

import com.techelevator.Creatures.monsters.Monster;

import java.util.Map;

public class UserOutput {

    public static void printGameTitle() {
        System.out.println("                                                                                                                                                                                                                  \n" +
                "     _____    ____   ____  _____   ______         _____         ______           _____  _____   ______               _____        _____          ____     _____            ____             ______        _____   \n" +
                " ___|\\    \\  |    | |    ||\\    \\ |\\     \\    ___|\\    \\    ___|\\     \\     ____|\\    \\|\\    \\ |\\     \\          ___|\\    \\   ___|\\    \\    ____|\\   \\   |\\    \\   _____  |    |        ___|\\     \\   ___|\\    \\  \n" +
                "|    |\\    \\ |    | |    | \\\\    \\| \\     \\  /    /\\    \\  |     \\     \\   /     /\\    \\\\\\    \\| \\     \\        /    /\\    \\ |    |\\    \\  /    /\\    \\  | |    | /    /| |    |       |     \\     \\ |    |\\    \\ \n" +
                "|    | |    ||    | |    |  \\|    \\  \\     ||    |  |____| |     ,_____/| /     /  \\    \\\\|    \\  \\     |      |    |  |    ||    | |    ||    |  |    | \\/     / |    || |    |       |     ,_____/||    | |    |\n" +
                "|    | |    ||    | |    |   |     \\  |    ||    |    ____ |     \\--'\\_|/|     |    |    ||     \\  |    |      |    |  |____||    |/____/ |    |__|    | /     /_  \\   \\/ |    |  ____ |     \\--'\\_|/|    |/____/ \n" +
                "|    | |    ||    | |    |   |      \\ |    ||    |   |    ||     /___/|  |     |    |    ||      \\ |    |      |    |   ____ |    |\\    \\ |    .--.    ||     // \\  \\   \\ |    | |    ||     /___/|  |    |\\    \\ \n" +
                "|    | |    ||    | |    |   |    |\\ \\|    ||    |   |_,  ||     \\____|\\ |\\     \\  /    /||    |\\ \\|    |      |    |  |    ||    | |    ||    |  |    ||    |/   \\ |    ||    | |    ||     \\____|\\ |    | |    |\n" +
                "|____|/____/||\\___\\_|____|   |____||\\_____/||\\ ___\\___/  /||____ '     /|| \\_____\\/____/ ||____||\\_____/|      |\\ ___\\/    /||____| |____||____|  |____||\\ ___/\\   \\|   /||____|/____/||____ '     /||____| |____|\n" +
                "|    /    | || |    |    |   |    |/ \\|   ||| |   /____ / ||    /_____/ | \\ |    ||    | /|    |/ \\|   ||      | |   /____/ ||    | |    ||    |  |    || |   | \\______/ ||    |     |||    /_____/ ||    | |    |\n" +
                "|____|____|/  \\|____|____|   |____|   |___|/ \\|___|    | / |____|     | /  \\|____||____|/ |____|   |___|/       \\|___|    | /|____| |____||____|  |____| \\|___|/\\ |    | ||____|_____|/|____|     | /|____| |____|\n" +
                "  \\(    )/       \\(   )/       \\(       )/     \\( |____|/    \\( |_____|/      \\(    )/      \\(       )/           \\( |____|/   \\(     )/    \\(      )/      \\(   \\|____|/   \\(    )/     \\( |_____|/   \\(     )/  \n" +
                "   '    '         '   '         '       '       '   )/        '    )/          '    '        '       '             '   )/       '     '      '      '        '      )/       '    '       '    )/       '     '   \n" +
                "                                                    '              '                                                   '                                            '                          '                ");
    }

    public static void printAdventureBegins() {
        System.out.println("\nThe Adventure Begins!\n");
        System.out.println("Press \"Enter\" to enter the dungeon");
    }

    public static void printMonsters(Map<String, Monster> monsterMap) {
        for (Map.Entry<String,Monster> entry : monsterMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public static void printBattleChoices() {
        System.out.println("What would you like to do?");
        System.out.println("[A]ttack");
        System.out.println("Use [I]tem");
        System.out.println("[R]un");
    }

    public static void printTargetChoices(String[] monsterArray) {
        System.out.println("Choose your target:");
        for (int i = 1; i <= monsterArray.length; i++) {
            System.out.println("[" + i + "] " + monsterArray[i - 1]);
        }
    }
}
