package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.FingerReaderEnia;
import game.actors.players.*;
import game.environments.*;
import game.items.GoldenRunes;
import game.utils.FancyMessage;
import game.actors.MerchantKale;
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
		Display display = new Display();

		display.println("Select your class");
		display.println("1) Samurai");
		display.println("2) Bandit");
		display.println("3) Wretch");
		display.println("4) Astrologer");
		char input = display.readChar();

		if (input == '1') {
			Player player = new Samurai();
			world.addPlayer(player, mapManager.Limgrave.at(37, 10));
		} else if (input == '2') {
			Player player = new Bandit();
			world.addPlayer(player, mapManager.Limgrave.at(37, 10));
		} else if (input == '3') {
			Player player = new Wretch();
			world.addPlayer(player, mapManager.Limgrave.at(37, 10));
		} else if (input == '4') {
			Player player = new Astrologer();
			world.addPlayer(player, mapManager.Limgrave.at(37, 10));
		}
		MerchantKale merchantKale = new MerchantKale();
		mapManager.Limgrave.at(38, 8).addActor(merchantKale);

		FingerReaderEnia fingerReaderEnia = new FingerReaderEnia();
		mapManager.Limgrave.at(38, 13).addActor(fingerReaderEnia);

		GoldenRunes goldenRunes = new GoldenRunes();
		mapManager.Limgrave.at(33, 10).addItem(goldenRunes);

		GoldenRunes goldenRunes2 = new GoldenRunes();
		mapManager.Limgrave.at(32, 10).addItem(goldenRunes2);


		world.run();
	}
}