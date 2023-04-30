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
		if (location.x() < 37) { // CHANGE 37 TO METHOD IN GAMEMAP
			spawnEnemy(2, giantCrab, location); // PUT PROBS AND SPAWN CHANCE IN PARENT, OVERWRITE IN CHILD ENEMIES
		}
		else {
			spawnEnemy(1, giantCrayFish, location);
		}
		// Math.floor(location.map().getXRange().max() / 2); GO INTO PARENT
	}
}
