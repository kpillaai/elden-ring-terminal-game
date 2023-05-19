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
 */
public class Graveyard extends Spawner {

	/**
	 * HeavySkeletalSwordsman is one of the enemies that can be spawned on a Graveyard ground
	 */
	private HeavySkeletalSwordsman heavySkeletalSwordsman;

	/**
	 * Skeletal Bandit is one of the enemies that can be spawned on a Graveyard ground
	 */
	private SkeletalBandit skeletalBandit;

	/**
	 * Constructor for Graveyard class
	 */
	public Graveyard() {
		super('n');
	}

	/**
	 * For each turn, the Graveyard has a 27% change of spawning an enemy based on whether it is on the east or
	 * west side of the map.
	 * @param location The location of the Ground
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
