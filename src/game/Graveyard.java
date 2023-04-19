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
public class Graveyard extends Ground {
	public Graveyard() {
		super('n');
	}
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	//public boolean isWest(){
		// if x is less than the middle of the map, then boolean west = true and enemytype is heavy skeletal swordsman
		// then if x is more than the middle of the map, boolean west = false and enemytype is skeletal bandit
	//}

	public boolean spawnSkeletalEnemy(){
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 27) {
			//spawn skeleton at this.Location()
			return true;
		}
		return false;
	}

}
