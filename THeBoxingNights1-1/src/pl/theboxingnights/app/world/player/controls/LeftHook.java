package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 12.06.15 / 18:47
 */
public class LeftHook extends AbstractKeyAction {
    public LeftHook(AbstractPlayer player) {
        super(player);
        setStamina(50f);
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
