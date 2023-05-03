package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.utils.Status;

/**
 * The weapon held by the Skeleton Variant 'Skeletal Bandit'.
 * It deals 75 damage with 70% hit rate
 * Created by: Jason Skurr
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Scimitar extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for Scimitar class.
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "swings", 88);
        this.addCapability(Status.AOE_ATTACK);
    }

    /**
     * Gets the sell price of this Scimitar
     * @return Integer representing the sell price of this Scimitar
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /**
     * Gets the buy price of this Scimitar. This number will be negative to represent losing Runes when purchasing
     * this item.
     * @return Negative Integer representing the buy price of this Scimitar
     */
    @Override
    public int getBuyPrice() {
        return -600;
    }

    /**
     * Returns the name of this Scimitar.
     * @return String representing the name of the Scimitar.
     */
    @Override
    public String toString() {
        return "Scimitar";
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