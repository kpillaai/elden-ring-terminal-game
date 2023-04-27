package game.items;

import edu.monash.fit2099.engine.items.Item;

public class Runes extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    int numberOfRunes = 0;
    public Runes() {
        super("Runes", '$', true);
    }

    public int getNumberOfRunes() {
        return numberOfRunes;
    }

    public void setNumberOfRunes(int numberOfRunes) {
        this.numberOfRunes = numberOfRunes;
    }

    public void updateNumberOfRunes(int number){
        this.numberOfRunes += number;
    }

    @Override
    public String toString() {
        return Integer.toString(numberOfRunes);
    }
}
