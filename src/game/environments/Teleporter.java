package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;
import game.utils.Status;
/**
 * Abstract class that allows players to teleport between maps
 * @author Zilei Chen
 *
 */
public abstract class Teleporter extends Ground {

    private Location teleportsTo;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Teleporter(char displayChar) {
        super(displayChar);
    }
    /**
     *
     * Method to check if Actor is able to enter the ground
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
     * When in proximity to the Teleporter, add a TeleportAction to the ActionList
     * @return actions once the TeleportAction has been added
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        actionList.add(new TeleportAction(this));
        return actionList;
    }
    /**
     * Setter for the Teleporter
     */
    public void setTeleportsTo(Location teleportsTo) {
        this.teleportsTo = teleportsTo;
    }
    /**
     * Getter for the Teleporter
     */
    public Location getTeleportsTo() {
        return teleportsTo;
    }
}
