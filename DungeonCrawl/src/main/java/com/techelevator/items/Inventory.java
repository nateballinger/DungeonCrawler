package com.techelevator.items;

import com.techelevator.Creatures.heros.Hero;

import java.util.HashMap;
import java.util.Map;


public class Inventory {

    private Map<Item, Integer> inventory = new HashMap<>();

    public void addItem(Item item, int num) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + num);
        } else {
            inventory.put(item, num);
        }
    }

    public void showInventory(boolean inBattle) {
        System.out.println("Current Inventory:");
        for (Map.Entry<Item,Integer> entry : inventory.entrySet()) {
            if (entry.getValue() > 0 && inBattle) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            } else if (entry.getValue() > 0 && entry.getKey().isPotion()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void useItem(Item item, Hero hero) {
        if (inventory.containsKey(item) && inventory.get(item) > 0) {
            item.use(hero);
            inventory.put(item,inventory.get(item) - 1);
        } else  {
            System.out.println("You do not have that item.");
        }
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }
}
