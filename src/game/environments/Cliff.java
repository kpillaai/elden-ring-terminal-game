package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FallAction;
import game.utils.Status;

/**
 * A class that represents a Cliff within the map.
 * @author Zilei Chen
 */
public class Cliff extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Cliff() {
        super('+');
    }
    /**
     *
     * Method to check if Actor is able to enter the cliff
     * @return boolean if actor can enter
     *
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * When standing on the Cliff, add a FallAction to the ActionList
     * @return actions once the FallAction has been added
     */
    @Override
    public void tick(Location location) {
        Actor player = location.getActor();
        if(player != null){
            player.hurt(999999);
            FallAction fallAction = new FallAction(player);
            fallAction.execute(player, location.map());
        }
    }
}
