package game.items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.ArrayList;

public interface Tradeable {
    public ArrayList<WeaponItem> tradeableItems();
}
