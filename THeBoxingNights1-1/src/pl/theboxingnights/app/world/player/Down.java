package pl.theboxingnights.app.world.player;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 16:36
 */
public class Down extends AbstractKeyAction {

    public Down(AbstractPlayer player) {
        super(player);
    }

    @Override
    public Vector3f getWalkDirection() {
        return new Vector3f(4, 0, 0);
    }
}