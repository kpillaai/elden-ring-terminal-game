package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.Behaviour;
import game.utils.RandomNumberGenerator;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Jason SKurr
 *
 */
public class WanderBehaviour implements Behaviour {
	
	private final Random random = new Random();

	/**
	 * Returns a MoveAction to wander to a random location, if possible.  
	 * If no movement is possible, returns null.
	 * 
	 * @param actor the Actor enacting the behaviour
	 * @param map the map that actor is currently on
	 * @return an Action, or null if no MoveAction is possible
	 */
	@Override
	public Action getAction(Actor actor, GameMap map) {
		ArrayList<Action> actions = new ArrayList<>();
		for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
            	actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }
		if (!actions.isEmpty()) {
			int despawnChance = RandomNumberGenerator.getRandomInt(100);
			if (despawnChance < 10) {
				map.removeActor(actor);}
			else{
				return actions.get(random.nextInt(actions.size()));
		}
			}
		return null;
	}
}
