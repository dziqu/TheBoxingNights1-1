package pl.theboxingnights.app.world.player;

import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 11:08
 */
public class Up extends AbstractKeyAction {

    public Up(AbstractPlayer player) {
        super(player);
    }

    @Override
    public Vector3f getWalkDirection() { return new Vector3f(-4, 0, 0); }
}
