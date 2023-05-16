package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SellAction;
import game.actions.TradeAction;
import game.actions.TradeItemAction;
import game.items.RemembranceOfTheGrafted;
import game.items.Tradeable;
import game.utils.Status;
import game.weapons.*;

import java.util.ArrayList;

public class FingerReaderEnia extends Actor {
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
    private Sellable astrologerStaff_sell = new AstrologerStaff();

    /**
     * A sellable RemembranceOfTheGrafted Item
     */
    private Sellable remembranceOfTheGrafted_sell = new RemembranceOfTheGrafted(false);

    /**
     * A sellable RemembranceOfTheGrafted Item
     */
    private Tradeable remembranceOfTheGrafted = new RemembranceOfTheGrafted(false);

    /**
     * A list of all sellable weapons.
     */
    private final ArrayList<Sellable> SELLABLE_ITEMS = new ArrayList<>();

    /**
     * A list of all sellable weapons.
     */
    private final ArrayList<Tradeable> TRADEABLE_ITEMS = new ArrayList<>();

    /**
     * Constructor.
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 500);
        SELLABLE_ITEMS.add(uchigatana_sell);
        SELLABLE_ITEMS.add(greatKnife_sell);
        SELLABLE_ITEMS.add(club_sell);
        SELLABLE_ITEMS.add(grossmesser);
        SELLABLE_ITEMS.add(scimitar_sell);
        SELLABLE_ITEMS.add(astrologerStaff_sell);
        SELLABLE_ITEMS.add(remembranceOfTheGrafted_sell);
        TRADEABLE_ITEMS.add(remembranceOfTheGrafted);
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

        for (int j = 0; j < SELLABLE_ITEMS.size(); j++) {
            // for weapons
            for (int i = 0; i < otherActor.getWeaponInventory().size(); i++) {
                if (otherActor.getWeaponInventory().get(i).toString().equals(SELLABLE_ITEMS.get(j).toString())) {
                    actions.add(new SellAction(SELLABLE_ITEMS.get(j)));
                }
            }
            // for items
            for (int k = 0; k < otherActor.getItemInventory().size(); k++) {
                if (otherActor.getItemInventory().get(k).toString().equals(SELLABLE_ITEMS.get(j).toString())) {
                    actions.add(new SellAction(SELLABLE_ITEMS.get(j)));
                }
            }
        }

        for (int m = 0; m < TRADEABLE_ITEMS.size(); m++) {
            for (int n = 0; n < otherActor.getItemInventory().size(); n++) {
                if (otherActor.getItemInventory().get(n).toString().equals(TRADEABLE_ITEMS.get(m).toString())) {
                    for (int o = 0; o < TRADEABLE_ITEMS.get(m).tradeableItems().size(); o++) {
                        actions.add(new TradeItemAction(TRADEABLE_ITEMS.get(m), TRADEABLE_ITEMS.get(m).tradeableItems().get(o)));
                    }
                }
            }
        }
        return actions;
    }

    /**
     * Select and return an action to perform on the current turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the Action to be performed
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }
}
