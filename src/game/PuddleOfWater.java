package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * A class that represents a graveyard.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class PuddleOfWater extends Ground {
	public PuddleOfWater() {
		super('~');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	public boolean spawnCrabEnemy(){
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 27) {
			//spawn dog at this.Location()
			return true;
		}
		return false;
	}
}
