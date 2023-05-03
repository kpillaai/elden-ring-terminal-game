package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.utils.Status;

/**
 * A class that represents a Site of Lost Grace within the map.
 * This particular location will give the option to rest and heal the player.
 * @author Jason Skurr
 *
 */
public class SiteOfLostGrace extends Ground {

    /**
     * Constructor for SiteOfLostGrace class.
     */
    public SiteOfLostGrace() {
        super('U');
        this.addCapability(Status.LOST_GRACE);
    }

    /**
     * Gives a list of all actions that can be done on the Site of Lost Grace, which is only to rest the
     * player.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return A list of only 1 Rest action.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new RestAction());
    }
}
