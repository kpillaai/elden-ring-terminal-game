package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Floor extends Ground {

	/**
	 * Constructor for Floor class.
	 */
	public Floor() {
		super('_');
	}

	/**
	 * Checks if a specific actor is able to enter this specific ground.
	 * @param actor the Actor to check
	 * @return Boolean representing if the actor can enter or not
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}
}
