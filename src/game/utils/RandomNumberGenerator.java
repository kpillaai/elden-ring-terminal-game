package game.utils;

import java.util.Random;

/**
 * A random number generator
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class RandomNumberGenerator {

    /**
     * Generates a random number between 0 and the bound specified.
     * @param bound Upper bound of the random number range.
     * @return Random Integer from 0 to bound
     */
    public static int getRandomInt(int bound) {
        return bound > 0 ? new Random().nextInt(bound) : 0;
    }

    /**
     * Generate a random number between 2 specified bounds
     * @param lowerBound The lower bound of the number range
     * @param upperBound The upper bound of the number range
     * @return Random Integer from lower to upper bound
     */
    public static int getRandomInt(int lowerBound, int upperBound) {
        int range = upperBound - lowerBound + 1;
        return new Random().nextInt(range) + lowerBound;
    }
}
