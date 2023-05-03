package game.utils;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface representing classes that is able to be reset
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public interface Resettable {

    /**
     * Resets the class
     * @param gameMap The map to be reset on.
     */
    void reset(GameMap gameMap);
}
