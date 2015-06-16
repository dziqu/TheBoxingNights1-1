package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 14:42
 */
public class Position extends AbstractKeyAction {


    public Position(AbstractPlayer player) {
        super(player);
        setStamina(0f);
    }

    @Override
    public Vector3f getWalkDirection() {
        return new Vector3f(0, 0, 0);
    }

    @Override
    public Quaternion getRotation() {
        return null;
    }

}
