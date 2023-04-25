package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class MerchantKale extends Actor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    private final int UCHIGATANA_PRICE = 5000;
    private final int GREAT_KNIFE_PRICE = 3500;
    private final int CLUB_PRICE = 600;
    private final int UCHIGATANA_SELL_PRICE = 500;
    private final int GREAT_KNIFE_SELL_PRICE = 350;
    private final int CLUB_SELL_PRICE = 100;
    private final String[] PURCHASABLE_ITEMS = {"Uchigatana", "Great Knife", "Club"};
    private final String[] SELLABLE_ITEMS = {"Uchigatana", "Great Knife", "Club", "Grossmesser"};
    public MerchantKale(String name, char displayChar, int hitPoints) {
        super("Merchant Kale", 'K', 500);
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

}
