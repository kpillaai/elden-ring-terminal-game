package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class SlamAttackAction extends AttackAction implements Behaviour{

    public SlamAttackAction() {
        super()
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }
}
