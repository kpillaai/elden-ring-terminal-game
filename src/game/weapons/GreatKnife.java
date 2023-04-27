package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * The starting weapon of the Bandit class.
 * It deals 75 damage with 70% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class GreatKnife extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor
     */
    public GreatKnife() {
        super("GreatKnife", '/', 75, "stabs", 70);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}

    @Override
    public int getSellPrice() {
        return 350;
    }

    @Override
    public int getBuyPrice() {
        return -3500;
    }

    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }
}