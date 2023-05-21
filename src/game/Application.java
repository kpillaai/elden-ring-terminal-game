package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.NPC.FingerReaderEnia;
import game.items.GoldenRunes;
import game.utils.PlayerSelectionManager;
import game.actors.enemies.LoneWolf;
import game.environments.*;
import game.utils.FancyMessage;
import game.actors.NPC.MerchantKale;
import game.utils.MapManager;

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

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(),
				new Graveyard(), new GustOfWind(), new PuddleOfWater(), new SiteOfLostGrace(), new Cliff(),
				new Cage(), new Barrack(), new SummonSign());

		// Generate all game maps
		MapManager mapManager = new MapManager(groundFactory);
		ArrayList<GameMap> gameMaps = mapManager.getGameMaps();
		for (GameMap map: gameMaps) {
			world.addGameMap(map);
		}


		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		PlayerSelectionManager playerSelectionManager = new PlayerSelectionManager();
		world.addPlayer(playerSelectionManager.selectCombatArchetype(), mapManager.Limgrave.at(37, 10));

		MerchantKale merchantKale = new MerchantKale();
		mapManager.Limgrave.at(38, 11).addActor(merchantKale);

		FingerReaderEnia fingerReaderEnia = new FingerReaderEnia();
		mapManager.Limgrave.at(38, 13).addActor(fingerReaderEnia);

		GoldenRunes goldenRunes1 = new GoldenRunes();
		mapManager.Limgrave.at(45, 13).addItem(goldenRunes1);

		GoldenRunes goldenRunes2 = new GoldenRunes();
		mapManager.Limgrave.at(28, 10).addItem(goldenRunes2);

		world.run();
	}
}