package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
import game.utils.Status;


/**
 * A class that represents the floor inside a building.
 * @author Jason Skurr
 *
 */
public class GustOfWind extends Spawner {
	private Enemy loneWolf;
	private Enemy giantDog;
	public GustOfWind() {
		super('&');
	}

	/**
	 * At each turn, this environment has a 33% chance of spawning its enemyType
	 */
	@Override
	public void tick (Location location){
		this.loneWolf = new LoneWolf();
		this.giantDog = new GiantDog();
		if (location.x() < 37) {
			spawnEnemy(loneWolf.getSpawnChance(), loneWolf, location);
		}
		else {
			spawnEnemy(giantDog.getSpawnChance(), giantDog, location);
		}
	}
}
