package game.weapons;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.DeathAction;
import game.actions.PoisonAction;
import game.behaviours.Behaviour;

import java.util.HashMap;
import java.util.Map;

public class PoisonStaff extends DelayedDamageWeapon {


    /**
     * Constructor.
     */
    public PoisonStaff() {
        super("Poison Staff", '|', 60, "attacks", 100);
    }

    /**
     * Get an active skill action from the weapon. Use this method if you want to use a weapon skill
     * against one targeted Actor (i.e, special attack, heal, stun, etc.).
     *
     * @param target    target actor
     * @param direction
     * @return a special Action that can be performed by this weapon (perform special attack on the enemy, etc.)
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new PoisonAction(target, direction, this);
    }
}
