package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 11:11
 */
public abstract class AbstractKeyAction implements KeyAction {

    private AbstractPlayer player = null;

    public AbstractKeyAction(AbstractPlayer player) {
        this.setPlayer(player);
    }

    public void make() {
        if (getWalkDirection() != null) {
            getPlayer().getBetterCharacterControl().setWalkDirection(getWalkDirection());
        }
        if (getRotation() != null) {
            getPlayer().getPlayerNode().rotate(getRotation());
        }
    }

    public AbstractPlayer getPlayer() {
        return player;
    }

    public abstract Vector3f getWalkDirection();

    public void setPlayer(AbstractPlayer player) {
        this.player = player;
    }
}
