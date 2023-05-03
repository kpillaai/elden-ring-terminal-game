package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents walls within the game map
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Wall extends Ground {

	/**
	 * Constructor for Wall class.
	 */
	public Wall() {
		super('#');
	}

	/**
	 * Checks if an actor is able to enter the wall.
	 * @param actor the Actor to check
	 * @return False since no actor should be able to walk through the walls
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	/**
	 * Checks if this ground will block projectiles or flying objects.
	 * @return True since no projectiles should pass through walls.
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
