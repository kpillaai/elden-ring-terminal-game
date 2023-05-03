package game.weapons;

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
     * Gets the WeaponItem equivalent of this Buyable interface.
     * @return WeaponItem representing this buyable weapon.
     */
    public WeaponItem returnWeaponItem();
}
