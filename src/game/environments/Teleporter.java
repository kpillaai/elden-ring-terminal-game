package game.environments;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;
import game.utils.Status;

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

    @Override
    public boolean canActorEnter(Actor actor) {
        if(actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actionList = new ActionList();
        actionList.add(new TeleportAction(this));
        return actionList;
    }

    public void setTeleportsTo(Location teleportsTo) {
        this.teleportsTo = teleportsTo;
    }

    public Location getTeleportsTo() {
        return teleportsTo;
    }
}
