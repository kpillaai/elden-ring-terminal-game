package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.utils.RandomNumberGenerator;

/**
 * An abstract class that inherits from Ground and its purpose is to randomly spawn enemies
 * on locations each turn.
 * @author Jason Skurr
 *
 */
public abstract class Spawner extends Ground {

    /**
     * Constructor for Spawner class
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
    }

    /**
     * Checks if the current ground is sitting on the east or west side of the game map.
     * @param location The location of the ground
     * @return A boolean stating if the ground is on the west or not.
     */
    public boolean isWest(Location location) {
        int middle = Math.floorDiv(location.map().getXRange().max(), 2);
        return location.x() < middle;
    }
}
