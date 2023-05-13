package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickstepAction;
import game.utils.Status;

/**
 * The starting weapon of the Astrologer class.
 * It deals 274 damage with 50% hit rate
 * Created by: Jason Skurr
 * @author Adrian Kristanto
 * Modified by:
 */
public class AstrologerStaff extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for AstrologerStaff class
     */
    public AstrologerStaff() {
        super("AstrologerStaff", 'f', 274, "casts", 50);
    }

    /**
     * Gets the sell price of this AstrologerStaff
     * @return Integer representing the sell price of this AstrologerStaff
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /**
     * Gets the buy price of this GreatKnife. This number will be negative to represent losing Runes when purchasing
     * this item.
     * @return Negative Integer representing the buy price of this AstrologerStaff
     */
    @Override
    public int getBuyPrice() {
        return -800;
    }

    /**
     * Returns the name of this GreatKnife.
     * @return String representing the name of the AstrologerStaff.
     */
    @Override
    public String toString() {
        return "AstrologerStaff";
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