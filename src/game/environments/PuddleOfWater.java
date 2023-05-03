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

	/**
	 * Giant Crab is one of the enemies that can be spawned on a Graveyard ground
	 */
	private Enemy giantCrab;

	/**
	 * Giant Crayfish is one of the enemies that can be spawned on a Graveyard ground
	 */
	private Enemy giantCrayFish;

	/**
	 * Constructor for PuddleOfWater class
	 */
	public PuddleOfWater() {
		super('~');
	}

	/**
	 * For each turn, the Puddle of Water has a 2% change of spawning an enemy based on whether it is on the east or
	 * west side of the map.
	 * @param location The location of the Ground
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
