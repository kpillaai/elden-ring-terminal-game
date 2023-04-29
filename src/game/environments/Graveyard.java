package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.SkeletalBandit;
import game.actors.enemies.Spawner;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.actors.enemies.Enemy;
import game.actors.enemies.HeavySkeletalSwordsman;


/**
 * A class that represents a Graveyard within the map.
 * @author Jason Skurr
 *
 */
public class Graveyard extends Spawner {
	private Enemy heavySkeletalSwordsman;
	private Enemy skeletalBandit;
	public Graveyard() {
		super('n');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}
	/**
	 * At each turn, this environment has a 27% chance of spawning its enemyType
	 */
	@Override
	public void tick (Location location){
		this.heavySkeletalSwordsman = new HeavySkeletalSwordsman();
		this.skeletalBandit = new SkeletalBandit();
		if (location.x() < 37) {
			spawnEnemy(27, heavySkeletalSwordsman, location);
		}
		else {
			spawnEnemy(27, skeletalBandit, location);
		}
	}
}
