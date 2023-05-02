package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.environments.SiteOfLostGrace;
import game.utils.FancyMessage;
import game.utils.ResetManager;
import game.utils.Resettable;
import game.items.Runes;
import game.utils.Status;
import game.items.FlaskOfCrimsonTears;
import game.weapons.Club;

import javax.swing.plaf.synth.SynthTableUI;

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

	private int[] lastGraceSite = {37, 10};

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(int hitPoints) {
		super("Tarnished", '@', hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		super.addItemToInventory(new Runes(false)); // always make sure the runes are at the start of the inventory
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

		display.println("HP: " + this.printHp());
		display.println("Flask: " + this.getUsesLeft());
		display.println("Runes: " + this.getRunes().getNumberOfRunes());

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}

	public Runes getRunes(){
		for (Item item : this.getItemInventory()){
			if (item.hasCapability(Status.CURRENCY)){
				return ((Runes) item);
			}
		}
		return null;
	}

	public int getUsesLeft(){
		for (Item item : this.getItemInventory()){
			if (item.hasCapability(Status.HEALING)){
				return ((FlaskOfCrimsonTears) item).getUsesLeft();
			}
		}
		return 0;
	}


	@Override
	public void addItemToInventory(Item item) {
		if(item.hasCapability(Status.CURRENCY)){
			getRunes().updateNumberOfRunes(((Runes) item).getNumberOfRunes());
		}
		else{
			super.addItemToInventory(item);
		}
	}

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
					droppedRunes.updateNumberOfRunes(((Runes) this.getItemInventory().get(i)).getNumberOfRunes());
					gameMap.at(lastDeathLocation[0], lastDeathLocation[1]).addItem(droppedRunes);
					this.getRunes().setNumberOfRunes(0);
				}
			}
			if (gameMap.at(lastGraceSite[0], lastGraceSite[1]).canActorEnter(this)) {
				gameMap.moveActor(this, gameMap.at(lastGraceSite[0], lastGraceSite[1]));
			}
		}
		this.resetMaxHp(this.getMaxHp());
		for (Item item : this.getItemInventory()){
			if (item.hasCapability(Status.HEALING)){
				((FlaskOfCrimsonTears) item).refresh();
			}
		}
	}
}
