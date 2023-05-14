package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.Dog;
import game.actors.enemies.Enemy;

public class Cage extends Spawner {

    private Enemy Dog;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Cage() {
        super('<');
    }

    @Override
    public void tick (Location location){
        this.Dog = new Dog();
        spawnEnemy(Dog.getSpawnChance(), Dog, location);
    }
}
