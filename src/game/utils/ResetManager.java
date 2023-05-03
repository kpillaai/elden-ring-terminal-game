package game.utils;

import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {

    /**
     * A list of all resettable classes.
     */
    private List<Resettable> resettables;

    /**
     * The ResetManager instance. This allows for only 1 ResetManager instance at ony give time.
     */
    private static ResetManager instance;

    /**
     * The gameMap to reset
     */
    private GameMap gameMap;

    /**
     * Returns the valid instance of ResetManager. Will create a new instance if no valid instance
     * is available
     * @param gameMap Map to be reset
     * @return The valid instance of ResetManager
     */
    public static ResetManager getInstance(GameMap gameMap) {
        if(instance == null){
            instance = new ResetManager(gameMap);
        }
        return instance;
    }

    /**
     * Returns the valid instance of ResetManager. Will create a new instance if no valid instance
     * is available
     * @return The valid instance of ResetManager
     */
    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Private constructor for ResetManager to allow for factory method to only allow 1 instance of ResetManager.
     * @param gameMap GameMap to be reset.
     */
    private ResetManager(GameMap gameMap) {
        this.resettables = new ArrayList<>();
        this.gameMap = gameMap;
    }

    /**
     * Private constructor for ResetManager to allow for factory method to only allow 1 instance of ResetManager.
     */
    private ResetManager(){
        this.resettables = new ArrayList<>();
    }

    /**
     * This method will call all resettable classes to reset themselves on the map.
     * @param gameMap GameMap to be reset on
     */
    public void run(GameMap gameMap) {
        for(Resettable resettable: this.resettables){ // reset the game (player hp, drop runes etc, flask of crimson tears)
            resettable.reset(gameMap);
        }
    }

    /**
     * Add a Resettable class to the list of resettables.
     * @param resettable
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }

    /**
     * Remove a Resettable class from the list of resettables
     * @param resettable
     */
    public void removeResettable(Resettable resettable) {
        this.resettables.remove(resettable);
    }
}
