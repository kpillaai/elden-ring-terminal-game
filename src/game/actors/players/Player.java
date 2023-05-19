package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.actors.CombatArchetypes;
import game.environments.SiteOfLostGrace;
import game.items.RemembranceOfTheGrafted;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.items.Runes;
import game.utils.Status;
import game.items.FlaskOfCrimsonTears;

import java.util.ArrayList;


/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a Flask Of Crimson Tears to heal itself when needed.
 * Created by: Zilei Chen
 * @author Adrian Kristanto
 * Modified by: Zilei Chen
 */
public class Player extends Actor implements Resettable {

	/**
	 * A menu showing the options that the Player is able to do each turn.
	 */
	private final Menu menu = new Menu();

	/**
	 * The last location the player was in x, y coordinates.
	 */
	private int[] lastLocation = {0, 0};

	/**
	 * The location of the last death of the player in x, y coordinates.
	 */
	private int[] lastDeathLocation = lastLocation;

	/**
	 * The last Site of Grace visited in x, y coordinates
	 */
	private int[] lastGraceSite = {37, 10};

	/**
	 * Runes that the player has
	 */
	private Runes runes = new Runes(false);

	/**
	 * The Flask of Crimson Tears that the player has
	 */
	private FlaskOfCrimsonTears flaskOfCrimsonTears = new FlaskOfCrimsonTears();

	private RemembranceOfTheGrafted remembranceOfTheGrafted = new RemembranceOfTheGrafted(false);

	/**
	 * Constructor for Player class. It also adds items to the player inventory that is necessary.
	 * It also adds the player to the ResetManager.
	 * @param hitPoints The number of hit points (HP) the player has.
	 */
	public Player(int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		super.addItemToInventory(this.runes); // always make sure the runes are at the start of the inventory
		this.addItemToInventory(this.flaskOfCrimsonTears);
		this.addItemToInventory(this.remembranceOfTheGrafted);

		ResetManager resetManager = ResetManager.getInstance();
		resetManager.registerResettable(this);
	}

	/**
	 * Updates the last coordinates of the player. Then presents the player a list of options that they are able to
	 * perform. Then performs the chosen action
	 * @param actions    collection of possible Actions for the Player
	 * @param lastAction The Action the Player took last turn. Can do interesting things in conjunction with Action.getNextAction()
	 * @param map        the map containing the Player
	 * @param display    the I/O object to which messages may be written
	 * @return The action that the player chose to perform.
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// saving the coordinates of the last location
		if(this.lastLocation[0] != map.locationOf(this).x()){
			this.lastLocation[0] = map.locationOf(this).x();
		}
		if(this.lastLocation[1] != map.locationOf(this).y()){
			this.lastLocation[1] = map.locationOf(this).y();
		}
		if(map.locationOf(this).getGround() instanceof SiteOfLostGrace){
			this.lastGraceSite[0] = map.locationOf(this).x();
			this.lastGraceSite[1] = map.locationOf(this).y();
		}

		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		display.println("HP: " + this.printHp());
		display.println("Flask: " + this.getUsesLeft());
		display.println("Runes: " + this.getRunes().getNumberOfRunes());

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Get the Runes item from the player inventory
	 * @return A Runes object representing the runes in the players inventory
	 */
	public Runes getRunes(){
		return this.runes;
	}

	/**
	 * Get the number of uses left in the players Flask of Crimson Tears
	 * @return An integer representing the number of uses left in the players Flask of Crimson Tears
	 */
	public int getUsesLeft(){
		return this.flaskOfCrimsonTears.getUsesLeft();
	}

	public int getHp(){
		return this.maxHitPoints;
	}

	/**
	 * Adds an Item to the player inventory. If the item is a Rune object, it will combine the number of runes together.
	 * @param item The Item to add.
	 */
	@Override
	public void addItemToInventory(Item item) {
		if(item.hasCapability(Status.CURRENCY)){
			this.runes.updateNumberOfRunes(Integer.parseInt(item.toString().substring(0, item.toString().length() - 6)));
		}
		else{
			super.addItemToInventory(item);
		}
	}

	/**
	 * Resets the player when the player rests or dies.
	 * It will reset the player's HP and Flasks of Crimson Tears uses.
	 * If the player died, it will drop the player's runes, as well as teleport the player back to the last visited
	 * Site of Lost Grace.
	 * @param gameMap The map the player is on.
	 */
	@Override
	public void reset(GameMap gameMap) {
		if(!this.isConscious()){
			// remove remaining runes off the ground
			for(Item item: gameMap.at(lastDeathLocation[0], lastDeathLocation[1]).getItems()){
				gameMap.at(lastDeathLocation[0], lastDeathLocation[1]).removeItem(item);
			}

			this.lastDeathLocation = lastLocation;
			for (int i = 0; i < this.getItemInventory().size(); i++) {
				if (this.getItemInventory().get(i).hasCapability(Status.CURRENCY)) {
					Runes droppedRunes = new Runes(true);
					droppedRunes.updateNumberOfRunes(this.getRunes().getNumberOfRunes());
					gameMap.at(lastDeathLocation[0], lastDeathLocation[1]).addItem(droppedRunes);
					this.getRunes().setNumberOfRunes(0);
				}
			}
			if (gameMap.at(lastGraceSite[0], lastGraceSite[1]).canActorEnter(this)) {
				gameMap.moveActor(this, gameMap.at(lastGraceSite[0], lastGraceSite[1]));
			}
		}
		this.resetMaxHp(this.getMaxHp());
		this.flaskOfCrimsonTears.refresh();
	}

	public void setCombatArchetype(int index) {
		ArrayList<CombatArchetypes> combatArchetypes = new ArrayList<>();
		// add combat archetypes to player
		// (have combat archetype manager that will ask for int from user and call this method)
		combatArchetypes.add(new Samurai());
		combatArchetypes.add(new Bandit());
		combatArchetypes.add(new Wretch());
		combatArchetypes.add(new Astrologer());

		this.addWeaponToInventory(combatArchetypes.get(index).getWeapon());
		this.increaseMaxHp(combatArchetypes.get(index).getHp());
	}

}
