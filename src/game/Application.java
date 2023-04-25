package game;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor());

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#________................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
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
		player.addItemToInventory(new Runes());
		world.addPlayer(player, gameMap.at(36, 10));

		HeavySkeletalSwordsman heavySkeletalSwordsman = new HeavySkeletalSwordsman();
		heavySkeletalSwordsman.behaviours.put(1, new AOEAttackActionBehaviour(heavySkeletalSwordsman.getWeaponInventory().get(0)));
		gameMap.at( 36, 9).addActor(heavySkeletalSwordsman);

		GiantCrab giantCrab = new GiantCrab();
		giantCrab.behaviours.put(1, new AOEAttackActionBehaviour(giantCrab.getIntrinsicWeapon()));
		gameMap.at( 36, 12).addActor(giantCrab);


		world.run();
	}
}
