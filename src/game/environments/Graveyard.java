package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.actors.enemies.Enemy;
import game.actors.enemies.HeavySkeletalSwordsman;


/**
 * A class that represents a Graveyard within the map.
 * @author Jason Skurr
 *
 */
public class Graveyard extends Ground {
	private String enemyType;
	public Graveyard() {
		super('n');
	}
	private Enemy newEnemy;

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	/**
	 * Defining the enemyType for this specific environment
	 */
	public String getEnemyType(){
		enemyType = "heavySkeletalSwordsman";
		return enemyType;
	}
	/**
	 * At each turn, this environment has a 27% chance of spawning its enemyType
	 */
	public void tick (Location location){
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 27) {
			String enemyType = getEnemyType();
			this.newEnemy = new HeavySkeletalSwordsman();
			if (!location.containsAnActor())
				location.addActor(this.newEnemy);
		}
		if (this.newEnemy != null){
			probability = RandomNumberGenerator.getRandomInt(100);
			if (probability < 10) {
				location.map().removeActor(this.newEnemy);
			}
		}
	}
}
