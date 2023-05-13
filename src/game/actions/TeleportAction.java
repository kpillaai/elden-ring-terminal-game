package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.environments.Teleporter;

public class TeleportAction extends Action {

    Teleporter teleporter;
    /**
     * Perform the Action.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a description of what happened that can be displayed to the user.
     */
    public TeleportAction(Teleporter teleporter){
        this.teleporter = teleporter;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        this.teleporter.getTeleportsTo().addActor(actor);
        return menuDescription(actor);
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports somewhere.";
    }
}
