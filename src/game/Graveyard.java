package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents a graveyard.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 *
 */
public class Graveyard extends Ground implements EnvironmentManager {
	public Graveyard() {
		super('n');
	}
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	public boolean IsWest() {
		//if x is less than half of map, enemy type = heavy skeletal swordsman and return TRUE
		if (Location.x() < 38){
			String EnemyType = heavyskeletalswordsman;
					return true;}
		//if X is more than half of map, enemy type = skeletal bandit and return FALSE
		String EnemyType = skeletalbandit;
		return false;
	}
	public boolean SpawnEnemy(){
		int probability = RandomNumberGenerator.getRandomInt(100);
		if (probability < 27) {
			//spawn enemy type at this.Location()
			return true;
		}
		return false;
	}


}
