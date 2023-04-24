package game;
import edu.monash.fit2099.engine.actors.Actor;

public class RunesManager {

    Actor player;

    Enemy enemy;

    public RunesManager(Actor player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public String rewardKillRunes(){
        String result = "";
        return result;
    }
}
