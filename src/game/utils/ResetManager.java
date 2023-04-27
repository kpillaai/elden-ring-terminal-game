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
    private List<Resettable> resettables;
    private static ResetManager instance;

    private GameMap gameMap;

    public static ResetManager getInstance(GameMap gameMap) {
        if(instance == null){
            instance = new ResetManager(gameMap);
        }
        return instance;
    }

    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * HINT 1: where have we seen a private constructor before?
     * HINT 2: see the instance attribute above.
     */
    private ResetManager(GameMap gameMap) {
        this.resettables = new ArrayList<>();
        this.gameMap = gameMap;
    }

    private ResetManager(){
        this.resettables = new ArrayList<>();
    }

    public void run(GameMap gameMap) {
        for(Resettable resettable: this.resettables){ // reset the game (player hp, drop runes etc, flask of crimson tears)
            resettable.reset(gameMap);
        }
    }

    public void registerResettable(Resettable resettable) {}

    public void removeResettable(Resettable resettable) {}
}
