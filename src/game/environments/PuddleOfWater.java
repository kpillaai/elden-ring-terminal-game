package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.actors.enemies.Enemy;
import game.actors.enemies.GiantCrab;


/**
 * A class that represents a Puddle of Water within the map.
 * @author Jason Skurr
 *
 */
public class PuddleOfWater extends Ground {
	private String enemyType;
	public PuddleOfWater() {
		super('~');
	}

	private String newEnemy;
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	/**
	 * Defining the enemytype for this specific environment
	 */
	public String getEnemyType(){
		enemyType = "giantCrab";
		return enemyType;
	}
	/**
	 * At each turn, this environment has a 2% chance of spawning its enemyType
	 */
	public void tick (Location location){
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 2) {
			String enemyType = getEnemyType();
			Enemy newEnemy;
			newEnemy = new GiantCrab();
			if (!location.containsAnActor())
				location.addActor(newEnemy);
		}
	}
}
