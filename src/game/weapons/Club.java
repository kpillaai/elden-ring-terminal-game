package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 103 damage with 80% hit rate
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 */
public class Club extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for Club weapon.
     */
    public Club() {
        super("Club", '!', 103, "bonks", 80);
    }

    /**
     * Gets the sell price of this Club
     * @return Integer representing the sell price of this Club
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /**
     * Gets the buy price of this Club. This number will be negative to represent losing Runes when purchasing
     * this item.
     * @return Negative Integer representing the buy price of this Club
     */
    @Override
    public int getBuyPrice() {
        return -600;
    }

    /**
     * Returns the name of this Club.
     * @return String representing the name of the Club.
     */
    @Override
    public String toString() {
        return "Club";
    }

    /**
     * Gets the WeaponItem equivalent of this Buyable interface.
     * @return WeaponItem representing this buyable weapon.
     */
    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }
}
