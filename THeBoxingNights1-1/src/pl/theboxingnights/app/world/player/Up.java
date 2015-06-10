package pl.theboxingnights.app.world.player;

import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 11:08
 */
public class Up implements Motion {

    private Vector3f motionVector = new Vector3f(-4, 0, 0);
    private Vector3f walkDirection = new Vector3f(-4, 0, 0);
    private AbstractPlayer player = null;

    public Up(AbstractPlayer player) {
        this.player = player;
    }

    @Override
    public void make() {
        player.getBetterCharacterControl().setWalkDirection(walkDirection);
    }

    private void setWalkDirection(Vector3f walkDirection) {
        this.walkDirection = walkDirection;
    }

    private Vector3f getWalkDirection() {
        return walkDirection;
    }

    private void resetWalkDirection() {
        walkDirection.set(0, 0, 0);
    }
}
