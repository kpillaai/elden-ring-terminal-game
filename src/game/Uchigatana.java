package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A starting weapon of the Samurai class
 * It deals 115 damage with 80% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem implements Sellable, Buyable{

    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slices", 80);
    }

    public int getBuyPrice() {
        return -5000;
    }

    @Override
    public int getSellPrice() {
        return 500;
    }

    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
