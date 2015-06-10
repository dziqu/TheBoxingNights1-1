package pl.theboxingnights.app.world.player;

import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 11:08
 */
public class Up implements Action {

    private Vector3f walkDirection = new Vector3f(-4, 0, 0);
    private AbstractPlayer player = null;

    public Up(AbstractPlayer player) {
        this.setPlayer(player);
    }

    @Override
    public void make() {
        getPlayer().getBetterCharacterControl().setWalkDirection(getWalkDirection());
    }

    private void setWalkDirection(Vector3f walkDirection) {
        this.walkDirection = walkDirection;
    }

    private Vector3f getWalkDirection() {
        return walkDirection;
    }

    private void resetWalkDirection() {
        getWalkDirection().set(0, 0, 0);
    }

    public AbstractPlayer getPlayer() {
        return player;
    }

    public void setPlayer(AbstractPlayer player) {
        this.player = player;
    }
}
