package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Buyable interface allows Weapons to be bought from a merchant.
 * @author
 */
public interface Sellable {

    /**
     * Gets the sell price of this weapon.
     * @return Integer representing the sell price of the weapon
     */
    public int getSellPrice();

    /**
     * Sells the item by removing the item from the actor's inventory and updating the number of runes the actor has.
     * @param actor the actor or player selling the item.
     */
    public String sell(Actor actor);
}
