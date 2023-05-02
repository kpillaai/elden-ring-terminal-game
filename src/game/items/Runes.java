package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.utils.Status;

/**
 * Runes class represents the runes a player has within the game. It also inherits from the Item abstract class.
 * A player can only have 1 Runes item in their inventory.
 * @author Zilei Chen
 * @version 1.0
 */
public class Runes extends Item {

    /**
     * The number of runes that this Runes item contains
     */
    int numberOfRunes = 0;

    /**
     * Constructor for Runes class.
     * @param portable Boolean representing if this item can be dropped or picked up.
     */
    public Runes(Boolean portable) {
        super("Runes", '$', portable);
        this.addCapability(Status.CURRENCY);
    }

    /**
     * Returns the number of runes this Runes class contains.
     * @return
     */
    public int getNumberOfRunes() {
        return numberOfRunes;
    }

    /**
     * Setter for numberOfRunes.
     * @param numberOfRunes An integer representing the number of runes that this Runes item contains
     */
    public void setNumberOfRunes(int numberOfRunes) {
        this.numberOfRunes = numberOfRunes;
    }

    /**
     * Changes the number of runes this Runes item has by adding to its current value. The parameter can also be a
     * negative number to indicate removing or losing number of Runes.
     * @param number Integer that represents how many runes is being removed or added from the Runes item.
     */
    public void updateNumberOfRunes(int number){
        this.numberOfRunes += number;
    }

    public String toString(){
        return Integer.toString(this.numberOfRunes) + " Runes";
    }
}