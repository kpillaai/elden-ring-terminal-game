package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Buyable interface allows Weapons to be bought from a merchant.
 * @author
 */
public interface Buyable {

    /**
     * Gets the buy price of this weapon.
     * @return Integer representing the buy price of the weapon
     */
    public int getBuyPrice();

    /**
     * Buys the item and gives the item to the actor.
     * @param actor the actor or player buying the item.
     */
    public String buy(Actor actor);
}
