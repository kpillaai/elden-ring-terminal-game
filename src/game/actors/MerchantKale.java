package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.BuyAction;
import game.environments.Wall;
import game.weapons.Buyable;
import game.actions.SellAction;
import game.weapons.Sellable;
import game.weapons.Club;
import game.weapons.GreatKnife;
import game.weapons.Grossmesser;
import game.weapons.Uchigatana;
import game.weapons.Scimitar;


import java.util.ArrayList;

public class MerchantKale extends Actor {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    private Sellable uchigatana_sell = new Uchigatana();
    private Sellable scimitar_sell = new Scimitar();
    private Sellable greatKnife_sell = new GreatKnife();
    private Sellable club_sell = new Club();
    private Sellable grossmesser = new Grossmesser();
    private Buyable uchigatana_buy = new Uchigatana();
    private Buyable greatKnife_buy = new GreatKnife();
    private Buyable club_buy = new Club();
    private Buyable scimitar_buy = new Scimitar();
    private final ArrayList<Sellable> SELLABLE_ITEMS = new ArrayList<>();
    private final ArrayList<Buyable> BUYABLE_ITEMS = new ArrayList<>();
    public MerchantKale() {
        super("Merchant Kale", 'K', 500);
        SELLABLE_ITEMS.add(uchigatana_sell);
        SELLABLE_ITEMS.add(greatKnife_sell);
        SELLABLE_ITEMS.add(club_sell);
        SELLABLE_ITEMS.add(grossmesser);
        SELLABLE_ITEMS.add(scimitar_sell);
        BUYABLE_ITEMS.add(uchigatana_buy);
        BUYABLE_ITEMS.add(greatKnife_buy);
        BUYABLE_ITEMS.add(club_buy);
        BUYABLE_ITEMS.add(scimitar_buy);
    }

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

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

}
