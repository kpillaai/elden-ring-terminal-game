package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.utils.Status;
import game.weapons.DelayedDamageWeapon;

public class PoisonAction extends AttackAction{
    private DelayedDamageWeapon delayedDamageWeapon;
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon
     */
    public PoisonAction(Actor target, String direction, DelayedDamageWeapon weapon) {
        super(target, direction, weapon);
        this.delayedDamageWeapon = weapon;
    }

    /**
     * When executed, the chance to hit of the weapon that the Actor used is computed to determine whether
     * the actor will hit the target. If so, deal damage to the target and determine whether the target is killed.
     *
     * @param actor The actor performing the attack action.
     * @param map   The map the actor is on.
     * @return the result of the attack, e.g. whether the target is killed, etc.
     * @see DeathAction
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        target.addCapability(Status.POISONED);
        delayedDamageWeapon.poisonTracker.put(target, 3);
        return super.execute(actor, map);
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Poison on " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");

    }
}
