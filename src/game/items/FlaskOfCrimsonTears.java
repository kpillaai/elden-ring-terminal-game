package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeHealAction;
import game.utils.Status;

import java.util.List;

/**
 * FlaskOfCrimsonTears is a class that inherits form Item class. It is a consumable item that restores the hp of the
 * user by 250. It has a maximum of 2 uses.
 * @author Zilei Chen
 * @version 1.0
 */
public class FlaskOfCrimsonTears extends Item {

    /**
     * The number of uses left in the Flask of Crimson Tears
     */
    private int usesLeft = 2;

    /**
     * The amount of HP the flask heals for each use
     */
    private final int healAmount = 250;

    /***
     * Constructor for Flask of Crimson Tears. It has an action that heals the user when executed.
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", 'f', false);
        this.addAction(new ConsumeHealAction(this));
        this.addCapability(Status.HEALING);
    }

    /**
     * Return the amount that the flasks heal for each use.
     * @return An integer representing the amount of HP the flask heals for
     */
    public int getHealAmount() {
        return healAmount;
    }

    /**
     * This method "uses" the Flask, reducing the number of uses by 1.
     */
    public void use(){
        String result = "";
        if (this.usesLeft > 0){
            this.usesLeft -= 1;
        }
    }

    /**
     * Getter for number of flask uses left.
     * @return An integer that represents the number of uses left for this Flask of Crimson Tears.
     */
    public int getUsesLeft(){
        return this.usesLeft;
    }

    /**
     * This method resets the number of uses left in the flask
     */
    public void refresh(){
        this.usesLeft = 2;
    }

    /**
     * This method returns the action that can be done to the flask. This action is an action that consumes a healing
     * item.
     * @return The action that heals the user when using Flask of Crimson Tears
     */
    @Override
    public List<Action> getAllowableActions() {
        if (this.usesLeft == 0){
            this.removeAction(new ConsumeHealAction(this));
        }
        return super.getAllowableActions();
    }
}
