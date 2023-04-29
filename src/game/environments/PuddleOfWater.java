package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
import game.utils.RandomNumberGenerator;
import game.utils.Status;


/**
 * A class that represents a Puddle of Water within the map.
 * @author Jason Skurr
 *
 */
public class PuddleOfWater extends Spawner {
	private Enemy giantCrab;
	private Enemy giantCrayFish;
	public PuddleOfWater() {
		super('~');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	/**
	 * At each turn, this environment has a 2% chance of spawning its enemyType
	 */
	@Override
	public void tick (Location location){
		this.giantCrab = new GiantCrab();
		this.giantCrayFish = new GiantCrayfish();
		if (location.x() < 37) {
			spawnEnemy(2, giantCrab, location);
		}
		else {
			spawnEnemy(1, giantCrayFish, location);
		}
	}
}
