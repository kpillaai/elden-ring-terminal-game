package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
import game.utils.RandomNumberGenerator;
/**
 * A class that represents a Barrack within the map.
 * @author Jason Skurr
 */
public class Barrack extends Spawner {
    /**
     * A Godrick Soldier is one of the enemies that can be spawned on a Barrack ground
     */
    private GodrickSoldier godrickSoldier;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Barrack() {
        super('B');
    }

    /**
     * For each turn, the Barrack has a 45% change of spawning a Godrick Soldier.
     * @param location The location of the Ground
     */

    @Override
    public void tick (Location location){
        this.godrickSoldier = new GodrickSoldier();
        spawnEnemy(godrickSoldier.getSpawnChance(), godrickSoldier, location);
        }
}

