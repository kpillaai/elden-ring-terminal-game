package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.BuyAction;
import game.actors.players.Astrologer;
import game.weapons.*;
import game.actions.SellAction;

import java.util.ArrayList;

/**
 * MerchantKale class is a class that represents the NPC Merchant Kale which allows players to trade weapons with.
 */
public class MerchantKale extends Actor {

    /**
     * A sellable Uchigatana weapon
     */
    private Sellable uchigatana_sell = new Uchigatana();

    /**
     * A sellable Scimitar weapon
     */
    private Sellable scimitar_sell = new Scimitar();

    /**
     * A sellable GreatKnife weapon
     */
    private Sellable greatKnife_sell = new GreatKnife();

    /**
     * A sellable Club weapon
     */
    private Sellable club_sell = new Club();

    /**
     * A sellable Grossmesser weapon
     */
    private Sellable grossmesser = new Grossmesser();

    /**
     * A sellable AstrologerStaff weapon
     */
    private Sellable astrologerstaff_sell = new AstrologerStaff();

    /**
     * A buyable Uchigatana weapon
     */
    private Buyable uchigatana_buy = new Uchigatana();

    /**
     * A buyable AstrologerStaff weapon
     */

    private Buyable astrologerstaff_buy = new AstrologerStaff();

    /**
     * A buyable GreatKnife weapon
     */
    private Buyable greatKnife_buy = new GreatKnife();

    /**
     * A buyable Club weapon
     */
    private Buyable club_buy = new Club();

    /**
     * A buyable Scimitar weapon
     */
    private Buyable scimitar_buy = new Scimitar();

    /**
     * A list of all sellable weapons.
     */
    private final ArrayList<Sellable> SELLABLE_ITEMS = new ArrayList<>();

    /**
     * A list of all purchasable weapons.
     */
    private final ArrayList<Buyable> BUYABLE_ITEMS = new ArrayList<>();

    /**
     * Constructor for MerchantKale. It adds a list of sellable and buyable items.
     */
    public MerchantKale() {
        super("Merchant Kale", 'K', 500);
        SELLABLE_ITEMS.add(uchigatana_sell);
        SELLABLE_ITEMS.add(greatKnife_sell);
        SELLABLE_ITEMS.add(club_sell);
        SELLABLE_ITEMS.add(grossmesser);
        SELLABLE_ITEMS.add(scimitar_sell);
        SELLABLE_ITEMS.add(astrologerstaff_sell);
        BUYABLE_ITEMS.add(uchigatana_buy);
        BUYABLE_ITEMS.add(greatKnife_buy);
        BUYABLE_ITEMS.add(club_buy);
        BUYABLE_ITEMS.add(scimitar_buy);
        BUYABLE_ITEMS.add(astrologerstaff_buy);

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
        for (int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
            for (int j = 0; j < SELLABLE_ITEMS.size(); j++) {
                if (otherActor.getWeaponInventory().get(i).toString().equals(SELLABLE_ITEMS.get(j).toString())) {
                    actions.add(new SellAction(SELLABLE_ITEMS.get(j)));
                }
            }
        }
        for (Buyable i : BUYABLE_ITEMS) {
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
