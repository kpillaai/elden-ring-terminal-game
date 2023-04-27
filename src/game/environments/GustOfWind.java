package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;
import game.utils.Status;
import game.actors.enemies.Enemy;
import game.actors.enemies.LoneWolf;


/**
 * A class that represents the floor inside a building.
 * @author Jason Skurr
 *
 */
public class GustOfWind extends Ground {
	private String enemyType;
	public GustOfWind() {
		super('&');
	}

	private String newEnemy;
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	/**
	 * Defining the enemyType for this specific environment
	 */
	public String getEnemyType(){
		enemyType = "loneWolf";
		return enemyType;
	}
	/**
	 * At each turn, this environment has a 33% chance of spawning its enemyType
	 */
	public void tick (Location location){
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 33) {
			String enemyType = getEnemyType();
			Enemy newEnemy;
			newEnemy = new LoneWolf();
			location.addActor(newEnemy);
		}
	}
}
