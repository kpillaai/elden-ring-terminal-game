package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.Enemy;

/**
 * A class that represents a Cage within the map.
 * @author Jason Skurr
 */
public class Cage extends Spawner {


    /**
     * A dog is one of the enemies that can be spawned on a Cage ground
     */
    private Dog dog;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Cage() {
        super('<');
    }

    /**
     * For each turn, a Cage has a 37% change of spawning a dog.
     * @param location The location of the Ground
     */
    @Override
    public void tick (Location location){
        this.dog = new Dog();
        spawnEnemy(dog.getSpawnChance(), dog, location);
    }
}
