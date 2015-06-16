package pl.theboxingnights.app.world.player.controls;

import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import pl.theboxingnights.app.world.AbstractPlayer;

/**
 * Created by filip / 10.06.15 / 11:08
 */
public class Up extends AbstractKeyAction {

    public Up(AbstractPlayer player) {
        super(player);
        setStamina(10f);
        setTacticLevel(1);
    }

    @Override
    public Vector3f getWalkDirection() {
        return new Vector3f(0, 0, -4);
    }

    @Override
    public Quaternion getRotation() {
        return null;
    }
}
