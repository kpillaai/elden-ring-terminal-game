package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SummonAction;

/**
 * A class that represents a Summon Sign within the map.
 * @author Zilei Chen
 *
 */
public class SummonSign extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public SummonSign() {
        super('=');
    }
    /**
     * When in proximity to the Summon Sign, add a SummonAction to the ActionList
     * @return actions once the SummonAction has been added
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        actions.add(new SummonAction(location));
        return actions;
    }
}
