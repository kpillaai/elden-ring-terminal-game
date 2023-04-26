package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.ArrayList;

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
    private Uchigatana uchigatana = new Uchigatana();
    private GreatKnife greatKnife = new GreatKnife();
    private Club club = new Club();
    private Grossmesser grossmesser = new Grossmesser();
    private final String[] PURCHASABLE_ITEMS = {"Uchigatana", "GreatKnife", "Club"};
    private final ArrayList<WeaponItem> SELLABLE_ITEMS = new ArrayList<>();
    public MerchantKale(String name, char displayChar, int hitPoints) {
        super("Merchant Kale", 'K', 500);
        SELLABLE_ITEMS.add(uchigatana);
        SELLABLE_ITEMS.add(greatKnife);
        SELLABLE_ITEMS.add(club);
        SELLABLE_ITEMS.add(grossmesser);
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        for(WeaponItem i : SELLABLE_ITEMS) {
            //if (otherActor.getWeaponInventory().get(i). )
            if (otherActor.getWeaponInventory().contains(i)) {
                // uchigatana there for the sake of no errors, ideally is just i
                actions.add(new SellAction(i, uchigatana));
            }
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return null;
    }

}
