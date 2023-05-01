package game.actions;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.ResetManager;
import game.environments.SiteOfLostGrace;

/**
 * An action executed when a player rests at a Site of Lost Grace
 * Created by: Zilei Chen
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 *
 */
public class RestAction extends Action {

    /**
     * A constructor for RestAction. Created for formalities.
     */
    public RestAction() {
    }

    /**
     * Perform the rest action. It will heal the player and reset the game.
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
            ResetManager resetManager = ResetManager.getInstance(map);
            resetManager.run(map);
        }
        return actor + " rests at the Site of Lost Grace";
    }

    /**
     * Returns a descriptive string of healing at the Site of Lost Grace
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " can rest at the Site of Lost Grace";
    }
}
