package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
import game.utils.Status;


/**
 * A class that represents a Gust Of Wind area within the map.
 * @author Jason Skurr
 */
public class GustOfWind extends Spawner {

	/**
	 * Lone Wolf is one of the enemies that can be spawned on a Graveyard ground
	 */
	private Enemy loneWolf;

	/**
	 * Giant Dog is one of the enemies that can be spawned on a Graveyard ground
	 */
	private Enemy giantDog;

	/**
	 * Constructor for GustOfWind class.
	 */
	public GustOfWind() {
		super('&');
	}

	/**
	 * For each turn, the Gust Of Wind has a 30% change of spawning an enemy based on whether it is on the east or
	 * west side of the map.
	 * @param location The location of the Ground
	 */
	@Override
	public void tick (Location location){
		this.loneWolf = new LoneWolf();
		this.giantDog = new GiantDog();
		if (this.isWest(location)) {
			spawnEnemy(loneWolf.getSpawnChance(), loneWolf, location);
		}
		else {
			spawnEnemy(giantDog.getSpawnChance(), giantDog, location);
		}
	}
}
