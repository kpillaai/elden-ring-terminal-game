package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.weapons.Sellable;

public class RemembranceOfTheGrafted extends Item implements Sellable {
    /***
     * Constructor.
     * @param portable true if and only if the Item can be picked up
     */
    public RemembranceOfTheGrafted(boolean portable) {
        super("Remembrance Of The Grafted", 'O', portable);
    }


    /**
     * Gets the sell price of this weapon.
     *
     * @return Integer representing the sell price of the weapon
     */
    @Override
    public int getSellPrice() {
        return 20000;
    }

    /**
     * Gets the WeaponItem equivalent of this Buyable interface.
     *
     * @return WeaponItem representing this buyable weapon.
     */
    @Override
    public Item returnWeaponItem() {
        return this;
    }
}
