package com.techelevator.dice;

public abstract class Dice {

    private int numberOfSides;

    public int roll(){
        return (int) (Math.random() * numberOfSides + 1);
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    @Override
    public String toString() {
        return "D" + numberOfSides;

    }
}
