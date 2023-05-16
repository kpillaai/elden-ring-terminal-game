package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Ally;
import game.actors.enemies.Invader;
import game.utils.RandomNumberGenerator;

public class SummonAction extends Action {

    Location currentLocation;
    public SummonAction(Location location) {
        this.currentLocation = location;
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
        if(RandomNumberGenerator.getRandomInt(100) < 50){
            map.addActor(new Ally(), this.currentLocation);
            return menuDescription(actor) + " an  Ally";
        }
        else{
            map.addActor(new Invader(), this.currentLocation);
            return menuDescription(actor) + " an  Invader";
        }
    }

    /**
     * Returns a descriptive string
     *
     * @param actor The actor performing the action.
     * @return the text we put on the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " activates the summon portal.";
    }
}
