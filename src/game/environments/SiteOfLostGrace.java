package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.RestAction;
import game.utils.Status;

public class SiteOfLostGrace extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SiteOfLostGrace() {
        super('U');
        this.addCapability(Status.LOST_GRACE);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        return new ActionList(new RestAction());

    }
}
