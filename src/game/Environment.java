package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
public class Environment extends Ground {
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    private int x;
    private int y;
    public Environment(char displayChar, int x, int y) {
        super(displayChar);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Location makeNewLocation(int x, int y){
        return new Location(this, x, y);
    }




}
