package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.ArrayList;

public class SlamAttackAction extends AttackAction implements Behaviour{

    private ArrayList<AttackAction> attackList;

    public SlamAttackAction(Actor target, String direction, Weapon weapon) {
        super(target, direction, weapon);
        this.attackList = new ArrayList<AttackAction>();
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }
}
