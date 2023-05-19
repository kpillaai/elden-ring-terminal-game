package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.SellAction;
import game.utils.Status;
import game.weapons.AxeOfGodrick;
import game.weapons.GraftedDragon;
import game.weapons.Sellable;

import java.util.ArrayList;

public class RemembranceOfTheGrafted extends Item implements Sellable{
    /***
     * Constructor.
     * @param portable true if and only if the Item can be picked up
     */
    public RemembranceOfTheGrafted(boolean portable) {
        super("Remembrance Of The Grafted", 'O', portable);
        this.addCapability(Status.TRADEABLE);
        this.addCapability(TradeName.REMEMBRANCE_OF_THE_GRAFTED);
    }


    /**
     * Gets the sell price of this weapon.
     *
     * @return Integer representing the sell price of the weapon
     */
    @Override
    public int getSellPrice() {
        return 20000;
    }

    /**
     * Sells the item by removing the item from the actor's inventory and updating the number of runes the actor has.
     *
     * @param actor the actor or player selling the item.
     */
    @Override
    public String sell(Actor actor) {
        Runes runes = new Runes(false);
        runes.setNumberOfRunes(this.getSellPrice());
        actor.addItemToInventory(runes);
        actor.removeItemFromInventory(this);
        return actor + " sells " + this + " for " + this.getSellPrice() + " Runes";
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        Boolean isTraderNear = false;
        for (Exit exits : currentLocation.getExits()) {
            if (exits.getDestination().containsAnActor()) {
                if(exits.getDestination().getActor().hasCapability(Status.TRADER)){
                    isTraderNear = true;
                }
                break;
            }
        }
        if(isTraderNear){
            if(this.getAllowableActions().size() == 0){
                this.addAction(new SellAction(this));
            }
        }
        else{
            for(Action action : this.getAllowableActions()){
                this.removeAction(action);
            }
        }
    }

}
