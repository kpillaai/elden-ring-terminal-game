package game.utils;

import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import game.environments.GoldenFogDoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapManager {
    /**
     * an array list of the game maps in the world
     */
    private ArrayList<GameMap> gameMaps = new ArrayList<>();
    /**
     * original gamemap that player spawns in
     */
    public GameMap Limgrave;
    /**
     * instantiates the class used to actually create the ground
     */
    private FancyGroundFactory groundFactory;

    /**
     * generates the map and sets teleporters
     * @param groundFactory used to create the map
     */
    public MapManager(FancyGroundFactory groundFactory){
        this.groundFactory = groundFactory;
        this.generateMaps();
        this.setTeleporters();
    }

    /**
     * generates the map and prints to the user
     */
    private void generateMaps(){
        List<String> mapLimgrave = Arrays.asList(
                "......................#.............#..........................+++.........",
                "......................#.............#.......................+++++..........",
                "......................#..___....____#.........................+++++........",
                "......................#...........__#............................++........",
                "......................#_____........#.............................+++......",
                "......................#............_#..............................+++.....",
                "......................######...######......................................",
                "...........................................................................",
                "...........................=...............................................",
                "........++++......................###___###................................",
                "........+++++++...................________#................................",
                "..........+++.....................#________................................",
                "............+++...................#_______#................................",
                ".............+....................###___###................................",
                "............++......................#___#..................................",
                "..............+...................=........................................",
                "..............++.................................................=.........",
                "..............................................++...........................",
                "..................++++......................+++...............######..##...",
                "#####___######....++...........................+++............#....____....",
                "_____________#.....++++..........................+..............__.....#...",
                "_____________#.....+....++........................++.........._.....__.#...",
                "_____________#.........+..+.....................+++...........###..__###...",
                "_____________#.............++..............................................");
        this.Limgrave = new GameMap(this.groundFactory, mapLimgrave);
        this.gameMaps.add(this.Limgrave);



        List<String> mapStormveilCastle = Arrays.asList(
                "...........................................................................",
                "..................<...............<........................................",
                "...........................................................................",
                "##############################################...##########################",
                "............................#................#.......B..............B......",
                ".....B...............B......#................#.............................",
                "...............................<.........<.................................",
                ".....B...............B......#................#.......B..............B......",
                "............................#................#.............................",
                "#####################..#############...############.####..#########...#####",
                "...............#++++++++++++#................#++++++++++++#................",
                "...............#++++++++++++...<.........<...#++++++++++++#................",
                "...............#++++++++++++..................++++++++++++#................",
                "...............#++++++++++++#................#++++++++++++#................",
                "#####...##########.....#############...#############..#############...#####",
                ".._______........................B......B........................B.....B...",
                "_____..._..____....&&........<..............<..............................",
                ".........____......&&......................................................",
                "...._______..................<..............<....................<.....<...",
                "#####....##...###..#####...##########___###############......##.....####...",
                "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++....................#+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++#....................+++++++++++++++++++++++++++",
                "+++++++++++++++++++++++++++#...................#+++++++++++++++++++++++++++");
        this.gameMaps.add(new GameMap(this.groundFactory, mapStormveilCastle));

        List<String> mapRoundtableHold = Arrays.asList(
                "##################",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "#________________#",
                "########___#######");
        this.gameMaps.add(new GameMap(this.groundFactory, mapRoundtableHold));

        List<String> mapBossRoom = Arrays.asList(
                "+++++++++++++++++++++++++",
                ".........................",
                "..=......................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                ".........................",
                "+++++++++++++++++++++++++");
        this.gameMaps.add(new GameMap(this.groundFactory, mapBossRoom));
    }

    /**
     * getter for game map
     * @return gameMaps
     */
    public ArrayList<GameMap> getGameMaps() {
        return gameMaps;
    }

    /**
     * setter for teleporters on the map
     */
    private void setTeleporters(){
        /*
        0. Limgrave
        1. Stormveil Castle
        2. Roundtable Hold
        3. Boss Room
         */
        GoldenFogDoor limgraveRoundtableHold = new GoldenFogDoor();
        GoldenFogDoor roundtableHoldLimgrave = new GoldenFogDoor();
        gameMaps.get(0).at(29, 0).setGround(limgraveRoundtableHold);
        gameMaps.get(2).at(9, 10).setGround(roundtableHoldLimgrave);
        limgraveRoundtableHold.setTeleportsTo(gameMaps.get(2).at(9, 10));
        roundtableHoldLimgrave.setTeleportsTo(gameMaps.get(0).at(29, 0));

        GoldenFogDoor limgraveStormveilCastle = new GoldenFogDoor();
        GoldenFogDoor stormveilCastleLimgrave = new GoldenFogDoor();
        gameMaps.get(0).at(6, 22).setGround(limgraveStormveilCastle);
        gameMaps.get(1).at(38, 22).setGround(stormveilCastleLimgrave);
        limgraveStormveilCastle.setTeleportsTo(gameMaps.get(1).at(1, 1));
        stormveilCastleLimgrave.setTeleportsTo(gameMaps.get(0).at(1, 1));

        GoldenFogDoor stormveilCastleBossRoom = new GoldenFogDoor();
        gameMaps.get(1).at(26, 0).setGround(stormveilCastleBossRoom);
        stormveilCastleBossRoom.setTeleportsTo(gameMaps.get(3).at(12, 7));
    }
}
