package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
import game.utils.RandomNumberGenerator;
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

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	/**
	 * At each turn, this environment has a 33% chance of spawning its enemyType
	 */
	@Override
	public void tick (Location location){
		this.loneWolf = new LoneWolf();
		this.giantDog = new GiantDog();
		if (location.x() < 37) {
			spawnEnemy(33, loneWolf, location);
		}
		else {
			spawnEnemy(4, giantDog, location);
		}
	}
}
