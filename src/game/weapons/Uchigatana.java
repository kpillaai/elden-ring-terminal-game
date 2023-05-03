package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.UnsheatheAction;
import game.utils.Status;

/**
 * A starting weapon of the Samurai class
 * It deals 115 damage with 80% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for Uchigatana class.
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slices", 80);
        this.addCapability(Status.UNSHEATHE);
    }

    /**
     * Gets the buy price of this Uchigatana. This number will be negative to represent losing Runes when purchasing
     * this item.
     * @return Negative Integer representing the buy price of this Uchigatana
     */
    public int getBuyPrice() {
        return -5000;
    }

    /**
     * Gets the sell price of this Uchigatana
     * @return Integer representing the sell price of this Uchigatana
     */
    @Override
    public int getSellPrice() {
        return 500;
    }

    /**
     * Gets the WeaponItem equivalent of this Buyable interface.
     * @return WeaponItem representing this buyable weapon.
     */
    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }

    /**
     * Returns the name of this Uchigatana.
     * @return String representing the name of the Uchigatana.
     */
    @Override
    public String toString() {
        return "Uchigatana";
    }

    /**
     * Get an active skill action from the weapon. This special action is the Unsheathe Action.
     * This allows the user to deal 2x damage but only have a 60% hit rate.
     * @param target    target actor
     * @param direction
     * @return a special Action UnsheatheAction.
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target, direction, this);
    }
}
