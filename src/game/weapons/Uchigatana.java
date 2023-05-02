package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.UnsheatheAction;
import game.utils.Status;

/**
 * A starting weapon of the Samurai class
 * It deals 115 damage with 80% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Uchigatana extends WeaponItem implements Sellable, Buyable {

    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115, "slices", 80);
        this.addCapability(Status.UNSHEATHE);
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
    public String toString() {
        return "Uchigatana";
    }

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     *
     * @param target    target actor
     * @param direction
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target, direction, this);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
