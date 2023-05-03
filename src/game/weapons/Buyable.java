package game.weapons;

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
     * Gets the WeaponItem equivalent of this Buyable interface.
     * @return WeaponItem representing this buyable weapon.
     */
    public WeaponItem returnWeaponItem();
}
