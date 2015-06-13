package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 12.06.15 / 11:16
 */
public class LeftJab extends AbstractKeyAction {
    public LeftJab(AbstractPlayer player) {
        super(player);
    }

    @Override
    public Vector3f getWalkDirection() {
        return null;
    }

    @Override
    public Quaternion getRotation() {
        return new Quaternion().fromAngles(0, 1f, 0);
    }
}
