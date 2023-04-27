package game.actors.players;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
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
		this.addItemToInventory(new Runes());
		this.addItemToInventory(new FlaskOfCrimsonTears());
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}



	@Override
	public void reset(GameMap gameMap) {
		this.resetMaxHp(this.getMaxHp());
		DropAction dropItemAction;
		if(!this.isConscious()){
			for (Item item : this.getItemInventory()){
				if (item instanceof Runes){
					dropItemAction = ((Runes) item).getDropAction(this);
					dropItemAction.execute(this, gameMap);
				}
			}
		}
	}
}
