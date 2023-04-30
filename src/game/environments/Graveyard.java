package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.SkeletalBandit;
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

	/**
	 * At each turn, this environment has a 27% chance of spawning its enemyType
	 */
	@Override
	public void tick (Location location){
		this.heavySkeletalSwordsman = new HeavySkeletalSwordsman();
		this.skeletalBandit = new SkeletalBandit();
		if (this.isWest(location)) {
			spawnEnemy(heavySkeletalSwordsman.getSpawnChance(), heavySkeletalSwordsman, location);
		}
		else {
			spawnEnemy(skeletalBandit.getSpawnChance(), skeletalBandit, location);
		}
	}
}
