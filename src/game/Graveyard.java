package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.NumberRange;


/**
 * A class that represents a graveyard.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Graveyard extends Environment {
	private String enemyType;
	public Graveyard(int x, int y) {
		super('n', x, y);
	}
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	public String getEnemyType() {
		if (this.x < 38) {
			enemyType = "heavySkeletalSwordsman";
		} else {
			enemyType = "skeletalBandit";
		}
		return enemyType;
	}
	@Override
	public void tick(Location location) {
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 27) {
			String enemyType = getEnemyType();
			Enemy newEnemy;
			if (enemyType.equals("heavySkeletalSwordsman")) {
				newEnemy = new HeavySkeletalSwordsman();
			} else {
				//newEnemy = new SkeletalBandit();
				newEnemy = new HeavySkeletalSwordsman();
			}
			gameMap.at(location.x(), location.y()).addActor(newEnemy);
		}
	}


}
