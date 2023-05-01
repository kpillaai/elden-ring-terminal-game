package game.actions;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.weapons.Uchigatana;

/**
 * An action executed when Unsheathe action is chosen which will do 2x damage but only have 60% accuracy.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class UnsheatheAction extends AttackAction {

    /**
     * Constructor for UnsheatheAction.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon An Uchigatana weapon
     */
    public UnsheatheAction(Actor target, String direction, Uchigatana weapon) {
        super(target, direction, weapon);
    }

    /**
     * This will update the accuracy and damage of the attack. Then execute the attack.
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return A string describing the attack that happened.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int chance_to_hit = 60;
        if (!(rand.nextInt(100) <= chance_to_hit)) {
            return actor + " misses " + target + ".";
        }

        int damage = 2 * weapon.damage();
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }
        return result;
    }

    /**
     * A description of using the Unsheathe attack on another actor
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Unsheathe on " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
