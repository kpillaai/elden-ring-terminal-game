package game.actors.NPC;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.BuyAction;
import game.actors.players.Astrologer;
import game.items.RemembranceOfTheGrafted;
import game.utils.Status;
import game.weapons.*;
import game.actions.SellAction;

import java.util.ArrayList;

/**
 * MerchantKale class is a class that represents the NPC Merchant Kale which allows players to trade weapons with.
 */
public class MerchantKale extends Actor {

    /**
     * A buyable Uchigatana weapon
     */
    private Buyable uchigatana = new Uchigatana();

    /**
     * A buyable AstrologerStaff weapon
     */

    private Buyable astrologerStaff = new AstrologerStaff();

    /**
     * A buyable GreatKnife weapon
     */
    private Buyable greatKnife= new GreatKnife();

    /**
     * A buyable Club weapon
     */
    private Buyable club = new Club();

    /**
     * A buyable Scimitar weapon
     */
    private Buyable scimitar = new Scimitar();

    /**
     * A list of all purchasable weapons.
     */
    private final ArrayList<Buyable> buyableItems = new ArrayList<>();

    /**
     * Constructor for MerchantKale. It adds a list of sellable and buyable items.
     */
    public MerchantKale() {
        super("Merchant Kale", 'K', 500);
        buyableItems.add(uchigatana);
        buyableItems.add(greatKnife);
        buyableItems.add(club);
        buyableItems.add(scimitar);
        buyableItems.add(astrologerStaff);
        this.addCapability(Status.TRADER);

    }

    /**
     * Returns a list of actions that the player is able to perform with Merchant Kale.
     * This will include a list of all purchasable weapons and a list of sellable items from the player's inventory.
     * @param otherActor the Player looking to trade
     * @param direction  Not applicable in this case.
     * @param map        current GameMap
     * @return The list of all available trading actions
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        for(WeaponItem weaponItem : otherActor.getWeaponInventory()){
            actions.add(weaponItem.getAllowableActions());
        }
        for (Buyable i : buyableItems) {
            actions.add((new BuyAction(i)));
        }
        return actions;
    }

    /**
     * Merchant Kale does not do anything in the map except for waiting for a player to trade with.
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return DoNothingAction.
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

}
