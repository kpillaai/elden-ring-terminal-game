package game.items;

import edu.monash.fit2099.engine.items.Item;
import game.utils.Status;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;
import game.weapons.Sellable;

import java.util.ArrayList;

public class RemembranceOfTheGrafted extends Item implements Sellable, Tradeable {
    /***
     * Constructor.
     * @param portable true if and only if the Item can be picked up
     */
    public RemembranceOfTheGrafted(boolean portable) {
        super("Remembrance Of The Grafted", 'O', portable);
        this.addCapability(Status.TRADEABLE);
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

    /**
     * @return
     */
    @Override
    public ArrayList<Item> tradeableItems() {
        ArrayList<Item> TRADEABLE_ITEMS = new ArrayList<>();
        TRADEABLE_ITEMS.add(new AxeOfGodrick());
        TRADEABLE_ITEMS.add(new GraftedDragon());
        return TRADEABLE_ITEMS;
    }
}
