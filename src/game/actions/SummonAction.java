package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.NPC.Ally;
import game.actors.enemies.Invader;
import game.utils.RandomNumberGenerator;

public class SummonAction extends Action {

    /**
     * the current location which Ally or Invader should be summoned at
     */
    Location currentLocation;

    /**
     * Constructor
     * @param location location where summoned entity should appear
     */
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
        //Checking for a location in a 1 unit radius to see if an actor can be spawned there
        if(this.currentLocation.containsAnActor()){
            for(Exit exit:this.currentLocation.getExits()){
                if(!exit.getDestination().containsAnActor()){
                    this.currentLocation = exit.getDestination();
                }
                break;
            }
        }

        if(RandomNumberGenerator.getRandomInt(100) < 50){
            map.addActor(new Ally(), this.currentLocation);
            return menuDescription(actor) + " An Ally spawns";
        }
        else{
            map.addActor(new Invader(), this.currentLocation);
            return menuDescription(actor) + " An Invader spawns";
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
