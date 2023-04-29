package game.actors.enemies;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

public class Spawner extends Ground {

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Spawner(char displayChar) {
        super(displayChar);
    }
    public void spawnEnemy(int probability, Enemy enemy, Location location) {
        int spawnChance = RandomNumberGenerator.getRandomInt(100);
        if (spawnChance < probability) {
            if (!location.containsAnActor())
                location.addActor(enemy);
        }
        if (enemy != null){
            int despawnChance = RandomNumberGenerator.getRandomInt(100);
            if (despawnChance < 10) {
                location.map().removeActor(enemy);
            }
        }
    }
}
