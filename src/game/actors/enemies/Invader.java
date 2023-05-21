package game.actors.enemies;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.AttackAction;
import game.actors.CombatArchetypes;
import game.actors.NPCCombatArchetype;
import game.actors.players.Astrologer;
import game.actors.players.Bandit;
import game.actors.players.Samurai;
import game.actors.players.Wretch;
import game.behaviours.BasicAttackActionBehaviour;
import game.behaviours.Behaviour;
import game.behaviours.FollowBehaviour;
import game.behaviours.WanderBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invader extends Enemy implements NPCCombatArchetype {

    /**
     * Constructor for Player class. It also adds items to the player inventory that is necessary.
     * It also adds the player to the ResetManager.
     *
     * @param hitPoints The number of hit points (HP) the player has.
     */
    public Invader() {
        super("Invader", 'ඞ', 1);
        this.addCapability(Status.ENEMY_NPC);
        this.applyRandomClass();
        this.behaviours.put(1, new BasicAttackActionBehaviour(this.getWeaponInventory().get(0)));
        super.setRuneDropValues(1358, 5578);
        super.spawnRunes();
        this.behaviours.remove(2);
        //this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Getter for the spawn chance of an enemy out of 100
     *
     * @return the spawn chance of an enemy out of 100
     */
    @Override
    public int getSpawnChance() {
        return 50;
    }



    /**
     *
     */
    @Override
    public void applyRandomClass() {
        ArrayList<CombatArchetypes> classes = new ArrayList<CombatArchetypes>();
        classes.add(new Astrologer());
        classes.add(new Bandit());
        classes.add(new Samurai());
        classes.add(new Wretch());
        int random = RandomNumberGenerator.getRandomInt(3);
        this.addWeaponToInventory(classes.get(random).getWeapon());
        this.resetMaxHp(classes.get(random).getHp());
    }

}
