package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.items.Item;

import java.util.Comparator;
import java.util.List;

public class FlaskOfCrimsonTears extends Item {

    private int usesLeft = 2;

    private final int healAmount = 250;

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'f', false);
        this.addAction(new ConsumeAction(this));
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void use(){
        String result = "";
        if (this.usesLeft > 0){
            this.usesLeft -= 1;
        }
    }

    @Override
    public List<Action> getAllowableActions() {
        if (this.usesLeft == 0){
            this.removeAction(new ConsumeAction(this));
        }
        return super.getAllowableActions();
    }
}
