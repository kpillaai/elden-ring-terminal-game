package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.actors.enemies.Enemy;
import game.environments.SiteOfLostGrace;
import game.utils.RandomNumberGenerator;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.items.Runes;
import game.utils.Status;
import game.items.FlaskOfCrimsonTears;
import game.weapons.Club;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	private int[] lastLocation = {0, 0};

	private int[] lastDeathLocation = lastLocation;

	private int[] lastGraceSite = lastLocation;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(new Club()); // remove if adding weapon when selecting class
		this.addItemToInventory(new Runes()); // always make sure the runes are at the start of the inventory
		this.addItemToInventory(new FlaskOfCrimsonTears());

		ResetManager resetManager = ResetManager.getInstance();
		resetManager.registerResettable(this);
	}

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

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	public Runes getRunes(){
		for (Item item : this.getItemInventory()){
			if (item instanceof Runes){
				return ((Runes) item);
			}
		}
		return null;
	}


	@Override
	public void addItemToInventory(Item item) {
		if(){

		}

		super.addItemToInventory(item);
	}

	@Override
	public void reset(GameMap gameMap) {
		this.resetMaxHp(this.getMaxHp());
		DropAction dropItemAction;
		if(!this.isConscious()){
			this.lastDeathLocation = lastLocation;
			for (Item item : this.getItemInventory()){
				if (item instanceof Runes){ // set current runes to 0, add new runes Item to the ground
					Runes droppedRunes = new Runes();
					droppedRunes.updateNumberOfRunes(Integer.parseInt(this.getItemInventory().get(1).toString()));
					gameMap.at(lastDeathLocation[0], lastDeathLocation[1]).addItem(droppedRunes);
					this.getRunes().setNumberOfRunes(0);
				}
				if (item instanceof FlaskOfCrimsonTears){
					((FlaskOfCrimsonTears) item).refresh();
				}
			}
			gameMap.moveActor(this, gameMap.at(lastGraceSite[0], lastGraceSite[1]));
		}
	}
}
