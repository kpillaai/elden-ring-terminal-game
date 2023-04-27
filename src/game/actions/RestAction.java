package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.ResetManager;
import game.environments.SiteOfLostGrace;

public class RestAction extends Action {
    public RestAction() {
    }

    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        // check where the player is
        Location player_location = map.locationOf(actor);

        // check the ground type where the player is
        Ground ground = player_location.getGround();

        // if the ground is the Site of Lost Grace
        if (ground instanceof SiteOfLostGrace) {
            ResetManager resetManager = ResetManager.getInstance();
            resetManager.run();
        }
        return actor + " rests at the Site of Lost Grace";
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " can rest at the Site of Lost Grace";
    }
}
