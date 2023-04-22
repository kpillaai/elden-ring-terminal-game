package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Grossmesser extends WeaponItem {

    /**
     * Constructor.
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "swings", 85);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {}
}
