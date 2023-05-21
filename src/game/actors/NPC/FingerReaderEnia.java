package game.actors.NPC;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SellAction;
import game.actions.TradeAction;
import game.actions.TradeItemAction;
import game.behaviours.Behaviour;
import game.items.RemembranceOfTheGrafted;
import game.items.TradeName;
import game.items.Tradeable;
import game.utils.Status;
import game.weapons.*;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FingerReaderEnia extends Actor {

    /**
     * List of available trades.
     */
    public Map<TradeName, ArrayList<Item>> tradeList = new HashMap<>();

    /**
     * Constructor.
     */
    public FingerReaderEnia() {
        super("Finger Reader Enia", 'E', 500);
        this.addTrades();
    }

    private void addTrades(){
        ArrayList<Item> remembranceTrades = new ArrayList<>();
        remembranceTrades.add(new AxeOfGodrick());
        remembranceTrades.add(new GraftedDragon());
        tradeList.put(TradeName.REMEMBRANCE_OF_THE_GRAFTED, remembranceTrades);
        this.addCapability(Status.PEACEFUL);

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
        // Finding all the tradable items in the actor's inventory
        ArrayList<Item> tradableItems = new ArrayList<>();
        for (Item item : otherActor.getItemInventory()){
            if(item.hasCapability(Status.TRADEABLE)){
                tradableItems.add(item);
            }
        }

        for(Item itemToGive : tradableItems){
            for(TradeName key : tradeList.keySet()){
                if(itemToGive.hasCapability(key)){
                    for(Item itemToReceive : tradeList.get(TradeName.REMEMBRANCE_OF_THE_GRAFTED)){
                        actions.add(new TradeAction(itemToGive, itemToReceive));
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
