package game.items;

import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.ArrayList;

/**
 * A tradeable interface representing when something is able to be traded
 */
public interface Tradeable {
    /**
     * tradeable weapons
     * @return an arraylist of weapon items that can be traded
     */
    public ArrayList<WeaponItem> tradeableItems();
}
