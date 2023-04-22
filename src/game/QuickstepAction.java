package game;

import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;


public class QuickstepAction extends AttackAction {
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon
     */
    public QuickstepAction(Actor target, String direction, GreatKnife weapon) {
        super(target, direction, weapon);
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        // find out where enemy and player is
        Location player_location = map.locationOf(actor);
        Location enemy_location = map.locationOf(target);

        // move to a square that ISN'T the intersection of enemies possible movements and our possible movements
        // use moveActor from GameMap to move actor to a new locatio

        for (int i = player_location.x() - 1; i <= player_location.x() + 1; i++) {
            for (int j = player_location.y() - 1; j <= player_location.y() + 1; i++) {
                if (new Location(map, i, j).canActorEnter(actor)) {
                    if (!new Location(map, i, j).canActorEnter(target)) {
                        map.moveActor(actor, new Location(map, i, j));
                    }
                }
            }
        }

        return super.execute(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " uses Quickstep on " + target + " at " + direction + " with " + (weapon != null ? weapon : "Intrinsic Weapon");
    }
}
