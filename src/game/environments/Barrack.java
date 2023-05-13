package game.environments;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.enemies.*;
import game.utils.RandomNumberGenerator;

public class Barrack extends Spawner {

    private Enemy godrickSoldier;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Barrack() {
        super('B');
    }

    /**
     * For each turn, the Barrack has a 45% change of spawning an enemy.
     * @param location The location of the Ground
     */

    @Override
    public void tick (Location location){
        this.godrickSoldier = new GodrickSoldier();
        spawnEnemy(godrickSoldier.getSpawnChance(), godrickSoldier, location);
        }
}

