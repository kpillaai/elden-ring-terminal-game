package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.behaviours.AOEAttackActionBehaviour;
import game.utils.Status;

/**
 * The starting weapon of the Heavy Skeletal Swordsman.
 * It deals 75 damage with 70% hit rate
 * Created by: Krishna Pillaai Manogaran
 * @author Adrian Kristanto
 * Modified by:
 */
public class Grossmesser extends WeaponItem implements Sellable {

    /**
     * Constructor for Grossmesser class.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "swings", 85);
        this.addCapability(Status.AOE_ATTACK);
    }

    /**
     * Gets the sell price of this Grossmesser
     * @return Integer representing the sell price of this Grossmesser
     */
    @Override
    public int getSellPrice() {
        return 1000;
    }

    /**
     * Returns the name of this Grossmesser.
     * @return String representing the name of the Grossmesser.
     */
    @Override
    public String toString() {
        return "Grossmesser";
    }

    /**
     * Gets the WeaponItem equivalent of this Buyable interface.
     * @return WeaponItem representing this buyable weapon.
     */
    @Override
    public WeaponItem returnWeaponItem() {
        return this;
    }


    @Override
    public Action getSkill(Actor holder) {
        return new AOEAttackActionBehaviour(this);
    }
}
