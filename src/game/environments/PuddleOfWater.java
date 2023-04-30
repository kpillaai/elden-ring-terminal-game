package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
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

	/**
	 * At each turn, this environment has a 2% chance of spawning its enemyType
	 */
	@Override
	public void tick (Location location){
		this.giantCrab = new GiantCrab();
		this.giantCrayFish = new GiantCrayfish();
		if (this.isWest(location)) {
			spawnEnemy(giantCrab.getSpawnChance(), giantCrab, location);
		}
		else {
			spawnEnemy(giantCrayFish.getSpawnChance(), giantCrayFish, location);
		}
	}
}
