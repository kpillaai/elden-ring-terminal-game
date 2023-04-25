package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;


/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
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

	public String getEnemyType(){
		enemyType = "loneWolf";
		return enemyType;
	}
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
