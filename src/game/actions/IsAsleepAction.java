package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.utils.Status;

public class IsAsleepAction extends DoNothingAction {
    /**
     * integer counter to count how many turns actor has been sleeping
     */
    int sleepCounter;

    /**
     * Constructor
     * @param sleepCounter integer to count how many turns actor has been asleep
     */
    public IsAsleepAction(int sleepCounter) {
        this.sleepCounter = sleepCounter;
    }

    /**
     * when this action is executed, it will return "actor does nothing"
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return the String describing that the current actor does nothing
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.hasCapability(Status.ASLEEP) && this.sleepCounter == 0) {
            actor.removeCapability(Status.ASLEEP);
        }
        return super.execute(actor, map);
    }

    /**
     * In the actions menu, the description for this action will be "actor does nothing"
     *
     * @param actor The actor performing the action.
     * @return the String "actor does nothing" to be shown in the menu
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " is asleep";    }

    /**
     * This provides a mechanism for Actions to take more than one turn.
     * For example, an action can change its state and return itself, or return the next Action in a series.
     * By default, this returns null, indicating that the Action will complete in one turn.
     *
     * @return the subsequent action in the series for multi-turn action or null if there is no next action available
     */
    @Override
    public Action getNextAction() {
        if (sleepCounter > 0) {
            sleepCounter -= 1;
            return new IsAsleepAction(sleepCounter);
        }
        else {
            return null;
        }
    }
}
