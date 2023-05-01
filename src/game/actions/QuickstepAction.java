package game.actions;
import java.lang.Math;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.weapons.GreatKnife;

/**
 * An action executed when Quick Step is chosen, which attacks an actor and moves the user away.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class QuickstepAction extends AttackAction {
    /**
     * Constructor for Quickstep Action.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon
     */
    public QuickstepAction(Actor target, String direction, GreatKnife weapon) {
        super(target, direction, weapon);
    }

    /**
     * Executes the attack, it will check for the actors surroundings and move to a valid location after attacking
     * @param actor The actor performing the attack action.
     * @param map The map the actor is on.
     * @return A string output of a description of the quick step attack
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // find out where enemy and player is
        Location player_location = map.locationOf(actor);
        Location enemy_location = map.locationOf(target);

        // move to a square that ISN'T the intersection of enemies possible movements and our possible movements
        // use moveActor from GameMap to move actor to a new locatio

        for (int i = player_location.x() - 1; i <= player_location.x() + 1; i++) {
            for (int j = player_location.y() - 1; j <= player_location.y() + 1; j++) {
                // check that (i, j) is
                if ((Math.abs(i - enemy_location.x()) + Math.abs(j - enemy_location.y())) > 2) {
                    if (map.at(i, j).canActorEnter(actor)) {
                        map.moveActor(actor, map.at(i, j));
                        break;
                    }
                }
            }
        }
        return super.execute(actor, map);
    }

    /**
     * Returns a descriptive string of using the quick step attack
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Quickstep on " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
