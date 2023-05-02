package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.utils.Status;

public class Runes extends Item {
    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    int numberOfRunes = 0;
    public Runes(Boolean portable) {
        super("Runes", '$', portable);
        this.addCapability(Status.CURRENCY);
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


}
