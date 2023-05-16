package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.QuickstepAction;
import game.utils.Status;

/**
 * The starting weapon of the Bandit class.
 * It deals 75 damage with 70% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 */
public class GreatKnife extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor for GreatKnife class
     */
    public GreatKnife() {
        super("GreatKnife", '/', 75, "stabs", 70);
        this.addCapability(Status.QUICKSTEP);
    }

    /**
     * Gets the sell price of this GreatKnife
     * @return Integer representing the sell price of this GreatKnife
     */
    @Override
    public int getSellPrice() {
        return 350;
    }

    /**
     * Gets the buy price of this GreatKnife. This number will be negative to represent losing Runes when purchasing
     * this item.
     * @return Negative Integer representing the buy price of this GreatKnife
     */
    @Override
    public int getBuyPrice() {
        return -3500;
    }

    /**
     * Returns the name of this GreatKnife.
     * @return String representing the name of the GreatKnife.
     */
    @Override
    public String toString() {
        return "Great Knife";
    }

    /**
     * Get an active skill action from the weapon. This skill will be the Quick Step.
     * It allows the actor to hit another enemy whilst also moving away from their attack range.
     * @param target    target actor
     * @param direction Direction of attack
     * @return QuickstepAction special skill
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickstepAction(target, direction, this);
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