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
 *
 */
public class GreatKnife extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor
     */
    public GreatKnife() {
        super("GreatKnife", '/', 75, "stabs", 70);
        this.addCapability(Status.QUICKSTEP);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public int getSellPrice() {
        return 350;
    }

    @Override
    public int getBuyPrice() {
        return -3500;
    }
    @Override
    public String toString() {
        return "GreatKnife";
    }

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     *
     * @param target    target actor
     * @param direction
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new QuickstepAction(target, direction, this);
    }

    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }
}