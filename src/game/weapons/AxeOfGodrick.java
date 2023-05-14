package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * The starting weapon of Godrick the Grafted
 * It deals 142 damage with 84% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 */
public class AxeOfGodrick extends WeaponItem implements Sellable {

    /**
     * Constructor for AxeOfGodrick class.
     */
    public AxeOfGodrick() {
        super("AxeOfGodrick", 'T', 142, "swings", 84);
    }

    /**
     * Gets the sell price of this AxeOfGodrick
     * @return Integer representing the sell price of this AxeOfGodrick
     */
    @Override
    public int getSellPrice() {
        return 100;
    }

    /**
     * Returns the name of this AxeOfGodrick.
     * @return String representing the name of the AxeOfGodrick.
     */
    @Override
    public String toString() {
        return "AxeOfGodrick";
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
