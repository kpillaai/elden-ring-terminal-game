package game;

import java.util.ArrayList;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Ally;
import game.actors.FingerReaderEnia;
import game.actors.PlayerSelectionManager;
import game.actors.enemies.Invader;
import game.actors.enemies.LoneWolf;
import game.actors.enemies.SkeletalBandit;
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

		PlayerSelectionManager playerSelectionManager = new PlayerSelectionManager();
		world.addPlayer(playerSelectionManager.selectCombatArchetype(), mapManager.Limgrave.at(37, 10));

		Invader invader = new Invader();
		mapManager.Limgrave.at(37, 9).addActor(invader);

		//SkeletalBandit skeletalBandit = new SkeletalBandit();
		//mapManager.Limgrave.at(37, 9).addActor(skeletalBandit);

		MerchantKale merchantKale = new MerchantKale();
		mapManager.Limgrave.at(38, 9).addActor(merchantKale);

		FingerReaderEnia fingerReaderEnia = new FingerReaderEnia();
		mapManager.Limgrave.at(38, 13).addActor(fingerReaderEnia);

		world.run();
	}
}