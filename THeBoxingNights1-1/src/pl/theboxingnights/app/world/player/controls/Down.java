package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
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
        return new Vector3f(0, 0, 4);
    }

    @Override
    public Quaternion getRotation() {
        return null;
    }
}
