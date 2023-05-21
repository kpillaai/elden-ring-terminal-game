package game.actors.enemies;

import game.actors.players.CombatArchetypes;
import game.actors.NPC.NPCCombatArchetype;
import game.actors.players.Astrologer;
import game.actors.players.Bandit;
import game.actors.players.Samurai;
import game.actors.players.Wretch;
import game.behaviours.BasicAttackActionBehaviour;
import game.utils.RandomNumberGenerator;
import game.utils.Status;

import java.util.ArrayList;
/**
 * Invader class
 * @author Krishna Managoran
 * @version 1.0
 */
public class Invader extends Enemy implements NPCCombatArchetype {

    /**
     * Constructor for Invader class. It also adds items to the Invader inventory that is necessary.
     * It also adds the Invader to the ResetManager.
     *
     * @param hitPoints The number of hit points (HP) the Invader has.
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
     * Method for Invader combat archetype to be randomly chosen.
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
