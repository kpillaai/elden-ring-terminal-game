package game.environments;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Enemy;
import game.utils.RandomNumberGenerator;

public abstract class Spawner extends Ground {

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
    }

    public boolean isWest(Location location) {
        int middle = Math.floorDiv(location.map().getXRange().max(), 2);
        return location.x() < middle;
    }
}
