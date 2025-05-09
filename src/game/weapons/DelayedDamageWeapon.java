package game.weapons;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.DeathAction;
import game.utils.Status;

import java.util.HashMap;
import java.util.Map;

public abstract class DelayedDamageWeapon extends WeaponItem {
    /**
     * damage done to an actor each turn
     */
    int damagePerTurn;
    /**
     * verb for damage done to actor each turn
     */
    String damagePerTurnVerb;

    public Map<Actor, Integer> damageTracker = new HashMap<>();
    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public DelayedDamageWeapon(String name, char displayChar, int damage, String verb, int hitRate, int damagePerTurn, String damagePerTurnVerb) {
        super(name, displayChar, damage, verb, hitRate);
        this.damagePerTurn = damagePerTurn;
        this.damagePerTurnVerb = damagePerTurnVerb;
    }

    /**
     * Inform a carried Item of the passage of time.
     * <p>
     * This method is called once per turn, if the Item is being carried.
     *
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor           The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        for (Actor target: damageTracker.keySet()) {
            if (damageTracker.get(target) > 0) {
                target.hurt(damagePerTurn);
                // CHANGE THIS TO DISPLAY
                Display display = new Display();
                display.println(target + " was " + damagePerTurnVerb + " for " + damagePerTurn + " damage");
                int counter = damageTracker.get(target) - 1;
                damageTracker.remove(target);
                if (counter <= 0) {
                    target.removeCapability(Status.POISONED);
                }
                else {
                    damageTracker.put(target, counter);
                }
                if (!target.isConscious()) {
                    new DeathAction(actor).execute(target, currentLocation.map());
                }
            }

        }
    }
}
