package game.utils;

/**
 * A spawnable interface representing actors that are able to be spawned via a RNG
 * @author Jason Skurr
 */
public interface Spawnable {
    /**
     * Getter for the spawn chance of an enemy out of 100
     * @return the spawn chance of an enemy out of 100
     */
    public abstract int getSpawnChance();

}
