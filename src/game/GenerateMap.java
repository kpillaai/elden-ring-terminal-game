package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;

public class GenerateMap extends GameMap {
    private List<String> lines;
    public GenerateMap(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
        this.lines = lines;
    }
    public void updateMap () {
        for (int x : widths) {
            for (int y : heights) {
                map[x][y].getGround().getDisplayChar();
            }
        }
        //if (this.at(x, y).getGround().getDisplayChar() == '&'){
        //location.setGround(new GustOfWind(x, y));
        //}
        //if (this.at(x, y).getGround().getDisplayChar() == '~'){
        //location.setGround(new PuddleOfWater(x, y));}
    //return super.makeNewLocation(x, y);
    }
}
