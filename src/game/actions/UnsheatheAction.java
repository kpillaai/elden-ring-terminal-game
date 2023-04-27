package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actions.DeathAction;
import game.weapons.Uchigatana;

public class UnsheatheAction extends AttackAction {

    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon uchigatana
     */
    public UnsheatheAction(Actor target, String direction, Uchigatana weapon) {
        super(target, direction, weapon);
    }

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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Unsheathe on " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
