package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.players.Player;
import game.behaviours.AOEAttackActionBehaviour;
import game.actors.enemies.GiantCrab;
import game.actors.enemies.HeavySkeletalSwordsman;
import game.actors.enemies.LoneWolf;
import game.behaviours.BasicAttackActionBehaviour;
import game.environments.*;
import game.utils.FancyMessage;
import game.actors.MerchantKale;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {
// committing new branch renaming
	public static void main(String[] args) {
		// test comment 12:56pm 17/04

		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace());

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######.........................nnn..........",
				"........~~~...........#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#..................&&&.................",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"............&&&............................................................",
				"......................................................nnn..................",
				"..................................###___###................................",
				"..........................U.......________#................................",
				"..................................#________................................",
				".............nnn..................#_______#................................",
				"..................................###___###..................~~~...........",
				"....................................#___#..................................",
				"...........................................................................",
				"...............&&&...............................~~~.......................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................&&&.............#....____....",
				"..#___........................nnnn..............................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"...........................................................................");
		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		// (23, 17)
		gameMap.at(36, 11).addActor(new LoneWolf());
		// HINT: what does it mean to prefer composition to inheritance?
		Player player = new Player("Tarnished", '@', 300);

		// Add newly implemented things here
		world.addPlayer(player, gameMap.at(37, 10));

		HeavySkeletalSwordsman heavySkeletalSwordsman = new HeavySkeletalSwordsman();
		gameMap.at( 36, 9).addActor(heavySkeletalSwordsman);

		GiantCrab giantCrab = new GiantCrab();
		gameMap.at( 36, 12).addActor(giantCrab);



		MerchantKale merchantKale = new MerchantKale();
		gameMap.at( 38, 9).addActor(merchantKale);

		world.run();
	}
}
