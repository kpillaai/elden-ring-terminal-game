package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * The starting weapon of Godrick the Grafted
 * It deals 89 damage with 90% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 */
public class GraftedDragon extends WeaponItem implements Sellable {

    /**
     * Constructor for GraftedDragon class.
     */
    public GraftedDragon() {
        super("GraftedDragon", 'N', 89, "swings", 90);
    }

    /**
     * Gets the sell price of this GraftedDragon
     * @return Integer representing the sell price of this GraftedDragon
     */
    @Override
    public int getSellPrice() {
        return 200;
    }

    /**
     * Returns the name of this GraftedDragon.
     * @return String representing the name of the GraftedDragon.
     */
    @Override
    public String toString() {
        return "GraftedDragon";
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
