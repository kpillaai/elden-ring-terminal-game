package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * The weapon held by the Skeleton Variant 'Skeletal Bandit'.
 * It deals 75 damage with 70% hit rate
 * Created by: Jason Skurr
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Scimitar extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor
     */
    public Scimitar() {
        super("Scimitar", 's', 118, "stabs", 88);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public int getSellPrice() {
        return 100;
    }

    @Override
    public int getBuyPrice() {
        return -600;
    }
    @Override
    public String toString() {
        return "Scimitar";
    }

    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }
}