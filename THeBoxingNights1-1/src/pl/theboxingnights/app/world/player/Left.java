package pl.theboxingnights.app.world.player;

import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 16:39
 */
public class Left extends AbstractKeyAction {

    public Left(AbstractPlayer player) {
        super(player);
    }

    @Override
    public Vector3f getWalkDirection() {
        return new Vector3f(0, 0, 4);
    }
}
