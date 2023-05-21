package game.actions;

import edu.monash.fit2099.engine.actors.Actor;

public class FallAction extends DeathAction{

    /**
     * The constructor for DeathAction class
     *
     * @param actor the actor that is killed
     */
    public FallAction(Actor actor) {
        super(actor);
    }

    /**
     * A menu description output after the action has occurred
     * @param actor The actor performing the action.
     * @return string output to describe what has happened
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " falls to its death";
    }
}
