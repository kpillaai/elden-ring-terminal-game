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

    @Override
    public String menuDescription(Actor actor) {
        return actor + " falls to its death";
    }
}
