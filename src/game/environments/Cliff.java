package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.FallAction;
import game.utils.Status;

public class Cliff extends Ground {


    public Cliff() {
        super('+');
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
    public void tick(Location location) {
        Actor player = location.getActor();
        FallAction fallAction = new FallAction(player);
        fallAction.execute(player, location.map());
    }
}
